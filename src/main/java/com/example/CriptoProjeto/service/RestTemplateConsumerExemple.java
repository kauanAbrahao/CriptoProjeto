package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.entity.Criptomoeda2;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@Controller
public class RestTemplateConsumerExemple {

    @Autowired
    private RestTemplate restTemplate;

    private final String GET_CRIPTOMOEDAS_URL = "https://api.coingecko.com/api/v3/coins/list";
    private final String URL_BUSCA_COIN_HISTORY = "https://api.coingecko.com/api/v3/coins/{id}/history";

    public void meuTemplate(){
        System.out.println("estou no meuTemplate");
        Criptomoeda2[] criptomoedas = restTemplate.getForObject(GET_CRIPTOMOEDAS_URL, Criptomoeda2[].class);
        System.out.println("RestTemplate: ");
        System.out.println(criptomoedas[0].toString());
    }


    public CriptoValorHistParser meuObjeto(String idCripto, String data){
        CriptoValorHistParser cripto = new CriptoValorHistParser();
        try {
            //Parâmetros de URL
            Map<String, String> urlParam = new HashMap<>();
            urlParam.put("id", idCripto );

            //Parâmetros de Query
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL_BUSCA_COIN_HISTORY)
                    .queryParam("date", data);

              cripto = restTemplate.getForObject(builder.buildAndExpand(urlParam).toUri(), CriptoValorHistParser.class);
//            cripto = restTemplate.getForObject(URL_BUSCA_COIN_HISTORY + idCripto + "/history?date=" + data, CriptoValorHistParser.class);
        }catch(ResourceAccessException e){
            System.out.println(e);
        }
        if (cripto.getMarketData() != null && cripto.getId() != null) {
            System.out.println(cripto.getId() + " current price brl: " + cripto.getMarketData().getCurrentPrice().getBrl() + "market cap brl:  " + cripto.getMarketData().getMarketCap().getBrl() + " total volume brl: " + cripto.getMarketData().getTotalVolume().getBrl());
        }
        return cripto;
    }




}
