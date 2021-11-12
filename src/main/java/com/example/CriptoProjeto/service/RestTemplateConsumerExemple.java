package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.entity.Criptomoeda2;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Controller
public class RestTemplateConsumerExemple {

    @Autowired
    private RestTemplate restTemplate;

    private final String GET_CRIPTOMOEDAS_URL = "https://api.coingecko.com/api/v3/coins/list";
    private final String PARSE_JSON = "https://api.coingecko.com/api/v3/coins/";

    public void meuTemplate(){
        System.out.println("estou no meuTemplate");
        Criptomoeda2[] criptomoedas = restTemplate.getForObject(GET_CRIPTOMOEDAS_URL, Criptomoeda2[].class);
        System.out.println("RestTemplate: ");
        System.out.println(criptomoedas[0].toString());
    }


    public CriptoValorHistParser meuObjeto(String idCripto, String data){
        CriptoValorHistParser cripto = new CriptoValorHistParser();
        try {
            cripto = restTemplate.getForObject(PARSE_JSON + "idCripto" + "/history?date=" + data, CriptoValorHistParser.class);
        }catch(ResourceAccessException e){
            System.out.println(e);
        }
        if (cripto.getMarketData() != null && cripto.getId() != null) {
            System.out.println(cripto.getId() + " current price brl: " + cripto.getMarketData().getCurrentPrice().getBrl() + "market cap brl:  " + cripto.getMarketData().getMarketCap().getBrl() + " total volume brl: " + cripto.getMarketData().getTotalVolume().getBrl());
        }
        return cripto;
    }




}
