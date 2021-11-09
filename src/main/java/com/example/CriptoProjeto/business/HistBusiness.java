package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonHistory;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Transactional
@Controller
@EnableScheduling
public class HistBusiness {
    @Autowired
    GsonHistory gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl moedaDao;

    @Scheduled(cron = "00 00 00 * * ?")
    public void insereTabValorCripto() {
        moedaDao.adicionarCriptoValorHistorico();
        moedaDao.deletarCriptoValor();
    }

    @Scheduled(cron = "00 18 22 * * ?")
    public void populaTabValorHist() throws IOException, InterruptedException {
       // gsonReceiver.getHistoryJson()
       LocalDate localDate = LocalDate.of(2021,11,06);
       String ld = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (EnumCripto e : EnumCripto.values()) {
            localDate = LocalDate.of(2021,11,06);
            while(localDate.isBefore(LocalDate.now())) {
                ld = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
               String json = gsonReceiver.getHistoryJson(e.getId(), ld);
                ld = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                CriptoValor criptovalor = (CriptoValor) GsonParser.jsonToObject(json, CriptoValor.class);
                System.out.println( criptovalor.getId()+ " "+ criptovalor.getCurrentPrice() + ld);
             //   if (criptovalor.getCurrentPrice() != null && criptovalor.getMktCap() != null && criptovalor.getTotalVolume() != null){
                moedaDao.adicionarCriptoValorHist(criptovalor, ld);
          //      }
                localDate = localDate.plusDays(1);
                TimeUnit.SECONDS.sleep(4);
            }
        }
        // moedaDao.
    }

}
