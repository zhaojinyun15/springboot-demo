package com.example.demo.service.impl;

import com.example.demo.model.MyCron;
import com.example.demo.service.CronService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j
@EnableScheduling
@Lazy
@Configuration
public class CronServiceImpl implements CronService, DisposableBean {
    private TaskScheduler taskScheduler;

    private static final Map<Integer, ScheduledFuture> FUTURE_MAP = new ConcurrentHashMap<>();

    private static final Map<Integer, String> cronMap = new ConcurrentHashMap<Integer, String>() {{
       put(1, "5/30 * * * * ?");
       put(2, "0/5 * * * * ?");
    }};

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.setThreadNamePrefix("CronService-");
        scheduler.setRemoveOnCancelPolicy(true);
        taskScheduler = scheduler;
        return scheduler;
    }

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
        for (Map.Entry<Integer, String> entry : cronMap.entrySet()) {
            Integer id = entry.getKey();
            String cron = entry.getValue();
            ScheduledFuture<?> schedule = taskScheduler.schedule(getRunnable(id, cron), getTriggerFromCron(cron));
            FUTURE_MAP.put(id, schedule);
        }
    }

    private Trigger getTriggerFromCron(String cron) {
        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(cron);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };
        return trigger;
    }

    private Runnable getRunnable(Integer id, String cron) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("id = {}, cron = {}", id, cron);
//                if (id == 1) {
//                    try {
//                        log.info("sleep start...");
//                        Thread.sleep(60000L);
//                        log.info("sleep end...");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
            }
        };
        return runnable;
    }

    @Override
    public void start() {
        log.info("start...");
        configureTasks(new ScheduledTaskRegistrar());
    }

    @Override
    public void stop() {
        log.info("stop...");
        try {
            cancelAllFutures(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(MyCron myCron) {
        Integer id = myCron.getId();
        String cron = myCron.getCron();
        if (FUTURE_MAP.containsKey(id)) {
            ScheduledFuture oldFuture = FUTURE_MAP.get(id);
            oldFuture.cancel(true);
            ScheduledFuture<?> newSchedule = taskScheduler.schedule(getRunnable(id, cron), getTriggerFromCron(cron));
            FUTURE_MAP.put(id, newSchedule);
        }
    }

    @Override
    public void destroy() {
        cancelAllFutures(true);
        FUTURE_MAP.clear();
        cronMap.clear();
        ((ThreadPoolTaskScheduler) taskScheduler).destroy();
    }

    private void cancelAllFutures(boolean mayInterruptIfRunning) {
        for (ScheduledFuture future : FUTURE_MAP.values()) {
            if (future != null) {
                future.cancel(mayInterruptIfRunning);
            }
        }
    }
}
