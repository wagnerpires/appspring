package com.wrtecnologia.appspring.utils;

import jakarta.annotation.PostConstruct;
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

    @Override
    public Health health(){
        return Health.up().withDetails(map).build();
    }

    @PostConstruct
    public void init() {
        map.put("AppStartIn: ", buscaDataHora());
    }

    private String buscaDataHora() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        return date.format(formatter);
    }

}
