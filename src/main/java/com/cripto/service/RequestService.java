package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RequestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${coingecko.getExtremosUrl}")
    private String extremosUrl;

    @Value("${coingecko.getHistoryUrl")
    private String historyUrl;


    /**
     * Requisição feita ao final do dia. Captura o maior e menor valor de cada criptomoeda para o dia de referência
     * @throws IOException
     */
    public List<CriptoExtremo> criptoExtremosRequest(){

        var response = restTemplate.getForEntity(extremosUrl, CriptoExtremo[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());
    }

    public List<CriptoValor> criptoValorRequest(){

        var response = restTemplate.getForEntity(extremosUrl, CriptoValor[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());

    }


    private void verificaStatusResponse(ResponseEntity<?> response) {

        if(response.getStatusCode().isError() || Objects.isNull(response.getBody())){
            throw new ResponseStatusException(response.getStatusCode(), String.format("Erro no request %s", extremosUrl));
        }
    }
}
