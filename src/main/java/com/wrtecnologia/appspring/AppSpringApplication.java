package com.wrtecnologia.appspring;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class AppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringApplication.class, args);
    }

    @PostConstruct
    public void init() {

        // Setting Spring Boot SetTimeZone
        log.info(String.valueOf(ZoneId.systemDefault()));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        log.info(String.valueOf(ZoneId.systemDefault()));
    }
}
