package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.Criptomoeda2;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Controller
public class RestTemplateConsumerExemple {

    @Autowired
    private RestTemplate restTemplate;

    private final String GET_CRIPTOMOEDAS_URL = "https://api.coingecko.com/api/v3/coins/list";
    private final String PARSE_JSON = "https://api.coingecko.com/api/v3/coins/true-usd/history?date=06-11-2021";

    public void meuTemplate(){
        System.out.println("estou no meuTemplate");
        Criptomoeda2[] criptomoedas = restTemplate.getForObject(GET_CRIPTOMOEDAS_URL, Criptomoeda2[].class);
        System.out.println("RestTemplate: ");
        System.out.println(criptomoedas[0].toString());
    }

    @Scheduled(fixedDelayString = "20000")
    public void meuObjeto(){
        CriptoValorHistParser cripto = restTemplate.getForObject(PARSE_JSON, CriptoValorHistParser.class);
        System.out.println("current price usd: " + cripto.getMarketData().getCurrentPrice().getUsd());
    }




}
