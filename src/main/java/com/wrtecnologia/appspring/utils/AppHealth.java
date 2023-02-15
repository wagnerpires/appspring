package com.wrtecnologia.appspring.utils;

import com.wrtecnologia.appspring.jobs.DateTimeJobs;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AppHealth implements HealthIndicator {

    protected static final Map<String, Object> map = new HashMap<>();

    public String startapp;

    @Autowired
    DateTimeJobs dateTimeJobs;

    @Override
    public Health health(){
        map.put("NextExecutionJob: ", dateTimeJobs.next());
        return Health.up().withDetails(map).build();
    }

    @PostConstruct
    public void init() {
        map.put("StartedSpringApplicationIn: ", buscaDataHora());
        startapp = buscaDataHora();
    }

    public void run() {
        // map.put("NextExecutionJob: ", dateTimeJobs.next());
    }

    private String buscaDataHora() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd/MM/uuuu HH:mm:ss");
        return date.format(formatter);
    }

}
