package com.wrtecnologia.appspring.controllers;

import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;

@RestController
public class UptimeApp {

    private static final long start = System.currentTimeMillis();

    @GetMapping("/up")
    public String uptimeApp() {
/*
        long millis = System.currentTimeMillis() - start;

        String uptime = String.format("%02d:%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis)   - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        return String.format("<h3>Uptime App: (up %s)</h3>", uptime);
 */
        long millis = System.currentTimeMillis() - start;

        String uptime = String.format("%02d:%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        //deprecated class
        CronSequenceGenerator cron1 = new CronSequenceGenerator("0 0 11 * * MON-FRI");
        // ÀS 11h de seg à sex (também pode-se usar números sendo o "1-5" seg à sex... "6" sábado... "0" domingo...

        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DATE, 4); // DATA PARA A PRÓXIMA SEXTA-FEIRA
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss");

        return String.format("<h3>Uptime App: (up %s)</h3>", uptime) + "<h4>" +
                "Data e hora atuais.: " + sdf.format(calendario.getTime()) + "<br>" +
                "Próxima Execução em: " + sdf.format(cron1.next(calendario.getTime())) + "</h4>";
    }
}