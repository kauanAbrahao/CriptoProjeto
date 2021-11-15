package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistParser;
import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonHistory;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.service.RestTemplateConsumerExemple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Transactional
@Controller
@EnableScheduling
public class HistBusiness {
    @Autowired
    GsonHistory gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl moedaDao;

    @Autowired
    RestTemplateConsumerExemple rest;


    @Scheduled(cron = "00 00 00 * * ?")
    public void insereTabValorCripto() {
        moedaDao.adicionarCriptoValorHistorico();
        System.out.println("Dados transferidos da Tab_valor para Tab_Valor_Hist");
        moedaDao.deletarCriptoValor();
        System.out.println("Dados antigos deletados da Tab_valor");
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void populaTabValorHist() throws IOException, InterruptedException {
       // gsonReceiver.getHistoryJson()
       LocalDate localDate = LocalDate.of(2021,01,01);
       String ld = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        for (EnumCripto e : EnumCripto.values()) {
            localDate = LocalDate.of(2021,9,8);
            while(localDate.isBefore(LocalDate.now())) {
                ld = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                CriptoValorHistParser criptovalor = rest.meuObjeto(e.getId(), ld);
                TimeUnit.SECONDS.sleep(3);
                if (criptovalor.getId() == null) {
                    criptovalor = rest.meuObjeto(e.getId(), ld);
                }
                ld = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println(criptovalor.getId() + " "+ ld);
                if (criptovalor.getMarketData() !=  null && criptovalor.getMarketData().getCurrentPrice().getBrl() != null && criptovalor.getMarketData().getMarketCap().getBrl() != null && criptovalor.getMarketData().getTotalVolume().getBrl() != null){
                   moedaDao.adicionarCriptoValorHist(criptovalor, ld);
              }
                localDate = localDate.plusDays(1);
            }
        }

    }

}
