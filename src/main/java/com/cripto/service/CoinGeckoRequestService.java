package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptoValorCoinMktCap;
import com.cripto.service.contracts.CoinRequest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import io.github.resilience4j.retry.annotation.Retry;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CoinGeckoRequestService implements CoinRequest {


    @Value("${coingecko.getExtremosUrl}")
    private String extremosUrl;

    @Value("${coingecko.getHistoryUrl")
    private String historyUrl;

    @Value("${coingecko.getMktRankAllCripto}")
    private String mktRankUrl;

    @Value("${coinMarketCap.apikey}")
    private String apiKey;

    final RestTemplate restTemplate;

    public CoinGeckoRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * Requisição feita ao final do dia. Captura o maior e menor valor de cada criptomoeda para o dia de referência
     * @throws IOException
     */
    @Retry(name = "criptoExtremoRetry", fallbackMethod = "criptoExtremoRequestErrorHandler")
    public List<CriptoExtremo> criptoExtremosRequest(){

        var response = restTemplate.getForEntity(extremosUrl, CriptoExtremo[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());
    }

    public List<CriptoExtremo> criptoExtremoRequestErrorHandler(Exception e){
        log.info("Política de retry criptoExtremoRetry iniciada");
        return  this.criptoExtremosRequest();
    }

    public List<CriptoValor> criptoValorRequest(){

        var response = restTemplate.getForEntity(extremosUrl, CriptoValor[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());

    }

    public List<Criptomoeda> criptoValorMktRankRequest() {

        var response = restTemplate.getForEntity(mktRankUrl + "?vs_currency=usd", Criptomoeda[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());
    }


    private void verificaStatusResponse(ResponseEntity<?> response) {

        if(response.getStatusCode().isError() || Objects.isNull(response.getBody())){
            log.error("HttpStatusRequest: " + response.getStatusCode());
            throw new ResponseStatusException(response.getStatusCode(), String.format("Erro no request %s", extremosUrl));
        }
    }

}
