package com.wrtecnologia.appspring.jobs;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class DiversosJobs {

    public static final String CRON_EXPRESSION = "0 0/30 * * * ?";
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd/MM/uuuu HH:mm:ss");

    @PostConstruct
    public void init() {
         /*
            Códigos de inicialização do job
         */
    }

    @Scheduled(cron = CRON_EXPRESSION)
    public void run() {
        LocalDateTime data = LocalDateTime.now();
        log.info("Rodando schedule em: " + data.format(formatter));
        log.info("Próxima execução em: " + next());
    }

    public String next() {
        CronExpression cronTrigger = CronExpression.parse(CRON_EXPRESSION);
        LocalDateTime next = cronTrigger.next(LocalDateTime.now());
        return next.format(formatter);
    }
}

/*

https://stackoverflow.com/questions/43766183/how-to-get-next-run-time-spring-scheduling

@Component
public class MyJob {

    public static final String CRON_EXPRESSION = "0 0 5 * * *";

    @PostConstruct
    public void init() {
        //Update: Resolve compile time error for static method `parse`
        CronExpression cronTrigger = CronExpression.parse(CRON_EXPRESSION);

        LocalDateTime next = cronTrigger.next(LocalDateTime.now());

        System.out.println("Next Execution Time: " + next);
    }

    @Scheduled(cron = CRON_EXPRESSION)
    public void run() {
        // Your custom code here
    }
}
 */