package com.wrtecnologia.appspring.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JobsDiversos {

    @Scheduled(cron= "0 0/1 * * * ?")
    public void verificaDataHoraAtual(){
        Date data = new Date();
        log.info("Rodando schedule - Última atualização: " + data);
    }
}
