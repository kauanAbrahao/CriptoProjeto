package com.cripto.service

import com.cripto.entity.CriptoExtremo
import com.cripto.entity.CriptoValor
import com.cripto.entity.Criptomoeda
import com.cripto.entity.dto.CriptoValorCoinMktCap
import com.cripto.service.contracts.CoinRequest
import com.cripto.util.ConverterDTO
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.Arrays.asList
import com.fasterxml.jackson.databind.ObjectMapper




@Service
@Slf4j
class CoinMktCapRequestService : CoinRequest {

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Value("\${coinMarketCap.getLatestValues}")
    lateinit var coinMarketCapLatestUrl: String

    @Value("\${coinMarketCap.apikey}")
    private val apiKey: String? = null

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun criptoValorRequest(): List<CriptoValor> {

        val httpHeaders = HttpHeaders();
        httpHeaders.set("X-CMC_PRO_API_KEY", apiKey)

        var  entity = HttpEntity<String>(null, httpHeaders)

        val response = restTemplate.exchange(coinMarketCapLatestUrl, HttpMethod.GET, entity,
                                             CriptoValorCoinMktCap::class.java)
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(response.body);

        logger.info("CoinMktCap Latest Value respose: " + response.statusCode.toString());
        return ConverterDTO.listCoinMktCapToEntity(response.body);
    }

    override fun criptoExtremosRequest(): MutableList<CriptoExtremo> {
        TODO("Not yet implemented")
    }

    override fun criptoValorMktRankRequest(): MutableList<Criptomoeda> {
        TODO("Not yet implemented")
    }

}