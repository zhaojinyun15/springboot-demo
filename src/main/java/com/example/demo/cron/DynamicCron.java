package com.example.demo.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

//@Component
@Slf4j
@EnableScheduling
public class DynamicCron implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        AtomicReference<String> cron = new AtomicReference<>("0/10 * * * * ?");
        taskRegistrar.addTriggerTask(() -> {
            log.info("DynamicCron: {}", cron);
            cron.set(getCron(cron.get()));
        }, triggerContext -> {
            CronTrigger cronTrigger = new CronTrigger(cron.get());
            return cronTrigger.nextExecutionTime(triggerContext);
        });
        taskRegistrar.addTriggerTask(() -> {
            log.info("DynamicCron2: {}", "0/8 * * * * ?");
        }, triggerContext -> {
            CronTrigger cronTrigger = new CronTrigger("0/8 * * * * ?");
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }

    private String getCron(String defaultCron) {
        if ("0/10 * * * * ?".equals(defaultCron)) {
            return "0/5 * * * * ?";
        } else {
            return "0/10 * * * * ?";
        }
    }
}
