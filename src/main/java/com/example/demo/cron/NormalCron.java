package com.example.demo.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
@EnableScheduling
@Async
public class NormalCron {
    @Scheduled(cron = "0/10 * * * * ?")
    public void cronJob() throws InterruptedException {
        log.info("cronJob, cron: {}", "0/10 * * * * ?");
        Thread.sleep(10000L);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void cronJob2() {
        log.info("cronJob2, cron: {}", "0/5 * * * * ?");
    }
}
