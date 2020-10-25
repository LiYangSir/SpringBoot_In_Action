package com.quguai.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "0 * * * * MON-FRI")
    public void hello(){
        System.out.println("Hello Scheduled");
    }
}
