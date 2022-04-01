package com.cripto.service

import com.cripto.entity.dto.CriptoValorCoinMktCap
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
@Slf4j
class CoinMktCapRequestService {

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Value("\${coinMarketCap.getLatestValues}")
    lateinit var coinMarketCapLatestUrl: String

    @Value("\${coinMarketCap.apikey}")
    private val apiKey: String? = null

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getLatestValueCoinMktCap(): ResponseEntity<*> {

        val httpHeaders = HttpHeaders();
        httpHeaders.set("X-CMC_PRO_API_KEY", apiKey)

        var  entity = HttpEntity<String>(null, httpHeaders)

        val response = restTemplate.exchange(coinMarketCapLatestUrl, HttpMethod.GET, entity,
                                             CriptoValorCoinMktCap::class.java)

        logger.info("CoinMktCap Latest Value respose: " + response.statusCode.toString());
        return response;
    }

}