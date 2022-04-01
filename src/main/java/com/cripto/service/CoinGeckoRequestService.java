package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptoValorCoinMktCap;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CoinGeckoRequestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${coingecko.getExtremosUrl}")
    private String extremosUrl;

    @Value("${coingecko.getHistoryUrl")
    private String historyUrl;

    @Value("${coingecko.getMktRankAllCripto}")
    private String mktRankUrl;

    @Value("${coinMarketCap.getLatestValues}")
    private String coinMarketCapLatestUrl;

    @Value("${coinMarketCap.apikey}")
    private String apiKey;


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

    public List<Criptomoeda> criptoValorMktRankRequest() {

        var response = restTemplate.getForEntity(mktRankUrl + "?vs_currency=usd", Criptomoeda[].class);

        verificaStatusResponse(response);

        return Arrays.asList(response.getBody());
    }


    public ResponseEntity<?> getLatestValueCoinMktCap(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-CMC_PRO_API_KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        var response = restTemplate.exchange(coinMarketCapLatestUrl, HttpMethod.GET, entity,  CriptoValorCoinMktCap.class);

        log.info(response.getStatusCode() + "\n" + response.getBody());

        return response;
    }

    private void verificaStatusResponse(ResponseEntity<?> response) {

        if(response.getStatusCode().isError() || Objects.isNull(response.getBody())){
            log.error("HttpStatusRequest: " + response.getStatusCode());
            throw new ResponseStatusException(response.getStatusCode(), String.format("Erro no request %s", extremosUrl));
        }
    }

}
