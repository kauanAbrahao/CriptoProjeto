package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

//@Controller
//@EnableScheduling
public class CriptomoedaBusiness {

    final String tempoReq = "6000";

   //  @Scheduled(fixedDelayString = tempoReq)
    public void buscaJsonCriptoValorScheduler() throws IOException {
        GsonReceiver gsonReceiver = new GsonReceiver();
        String json = gsonReceiver.getCriptoJsonMarkets();

         List<CriptoValor> criptomoedaList = GsonParser.jsonToObjectList(json, true);
         System.out.println(criptomoedaList.get(0).toString());
    }

   // @Scheduled(cron = "0 50 20 * * ?")
    public void buscaJsonCriptoExtremosScheduler() throws IOException {
        GsonReceiver gsonReceiver = new GsonReceiver();
        String json = gsonReceiver.getCriptoJsonMarkets();

        List<CriptoValor> criptomoedaList = GsonParser.jsonToObjectList(json, true);
        System.out.println(criptomoedaList.get(0).toString());
    }

}
