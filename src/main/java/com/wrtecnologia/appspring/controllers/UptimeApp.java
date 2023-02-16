package com.wrtecnologia.appspring.controllers;

import com.wrtecnologia.appspring.jobs.DateTimeJobs;
import com.wrtecnologia.appspring.utils.AppHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;

@RestController
public class UptimeApp {

    private static final long start = System.currentTimeMillis();

    @Autowired
    DateTimeJobs diversosJobsDateTime;

    @Autowired
    AppHealth appHealth;

    @GetMapping("/up")
    public String uptimeApp() {

        long millis = System.currentTimeMillis() - start;

        String uptime = String.format("%02d:%02d:%02d:%02d", TimeUnit.MILLISECONDS.toDays(millis), TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        // LocalDateTime date = LocalDateTime.now().plusDays(4); // ADD DAYS IN DATE
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd/MM/uuuu HH:mm:ss");

        return String.format(
                "<p><strong><font color=\"red\" face=\"Courier\" size=\"3\">Railway App Server (AppspringApplication)</strong></p>" +
                "<p><strong><font color=\"blue\" face=\"Courier\" size=\"2\">Server date/time..: </strong>" + date.format(formatter) + "</font>" +
                "<strong><font color=\"black\" face=\"Courier\" size=\"2\"><br>Start in..........: </strong>" + appHealth.startapp + "</font>" +
                "<strong><font color=\"black\" face=\"Courier\" size=\"2\"><br>Uptime............:</strong> %s", uptime) + "</font><br>" +
                "<strong><font color=\"black\" face=\"Courier\" size=\"2\">Next execution job: </strong>" + diversosJobsDateTime.next() + "</font></p>" +
                "<p><strong><font color=\"black\" face=\"Courier\" size=\"2\">by Wagner Pires (dev)</font></strong></p>";
    }
}