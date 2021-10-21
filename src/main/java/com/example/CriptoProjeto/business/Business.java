package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
@EnableScheduling
public class Business {
    CriptomoedaDAOImpl moedaDAO;
    GsonReceiver gsonReceiver;
    GsonParser gsonParser;

    public List <CriptoValor> fetchJsonMarkets() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoValor> criptomoedaList = GsonParser.jsonToObjectList(json, true);

        return criptomoedaList;

    }

    public List <CriptoValor> fetchJsonCriptoList() throws IOException {
        String json = gsonReceiver.getListCriptoJson();
        List<CriptoValor> criptomoedaList = GsonParser.jsonToObjectList(json, true);
        return criptomoedaList;
    }

    @Scheduled(cron = "0 10 17 * * ?")
    public CriptoValor fetchJsonCripto() throws IOException {
        String json = gsonReceiver.getCriptoJson();
        CriptoValor criptovalor;
      //  criptomoeda = GsonParser.jsonToObject(json);
      //  moedaDAO.adicionarCriptoValor(criptomoeda);
        return criptomoeda;
    }






}
