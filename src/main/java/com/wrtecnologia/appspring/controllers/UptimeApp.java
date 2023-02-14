package com.wrtecnologia.appspring.controllers;

import com.wrtecnologia.appspring.jobs.DateTimeJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;

@RestController
public class UptimeApp {

    private static final long start = System.currentTimeMillis();

    @Autowired
    DateTimeJobs diversosJobsDateTime;

    @GetMapping("/up")
    public String uptimeApp() {

        long millis = System.currentTimeMillis() - start;

        String uptime = String.format("%02d:%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        Calendar calendario = Calendar.getInstance();
        //calendario.add(Calendar.DATE, 4); // DATA PARA A PRÓXIMA SEXTA-FEIRA
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd/MM/uuuu HH:mm:ss");

        return String.format("<h3>Tempo em execução (aplicação): up %s</h3>", uptime) + "<h4>" +
                "Data e hora atuais: " + sdf.format(calendario.getTime()) + "<br>" +
                "Próxima execução (job) em: " + diversosJobsDateTime.next() + "</h4>";
    }
}