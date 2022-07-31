package com.example.demo.controller;

import com.example.demo.model.MyCron;
import com.example.demo.service.CronService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/cron")
public class CronController {
    @Autowired
    private CronService cronService;

    @RequestMapping("/start")   // http://localhost:8080/cron/start
    public String startCron() {
        cronService.start();
        return "success";
    }

    @PostMapping("/update")   // http://localhost:8080/cron/update
    public String updateCron(@RequestBody MyCron myCron) {
        log.info("update cron: {}", myCron);
        cronService.update(myCron);
        return "success";
    }
}
