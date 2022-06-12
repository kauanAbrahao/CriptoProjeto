package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptoValorCoinMktCap;
import com.cripto.service.contracts.CoinRequest;
import com.cripto.util.ConverterDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CoinMktCapRequestService implements CoinRequest {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${coinMarketCap.getLatestValues}")
    private String coinMarketCapLatestUrl;

    @Value("${coinMarketCap.apikey}")
    private String apiKey;


    @Override
    public List<CriptoValor> criptoValorRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        var entity = new HttpEntity<String>(null, headers);
        var response = restTemplate.exchange(coinMarketCapLatestUrl, HttpMethod.GET,
                entity, CriptoValorCoinMktCap.class);

        if(response.getStatusCode().isError() || Objects.isNull(response.getBody())){
            log.error("HttpStatusRequest: " + response.getStatusCode());
            throw new ResponseStatusException(response.getStatusCode(), String.format("Erro no request %s", coinMarketCapLatestUrl));
        }

        return ConverterDTO.listCoinMktCapToEntity(response.getBody());
    }

    @Override
    public List<CriptoExtremo> criptoExtremosRequest() {
        return null;
    }

    @Override
    public List<Criptomoeda> criptoValorMktRankRequest() {
        return null;
    }
}
