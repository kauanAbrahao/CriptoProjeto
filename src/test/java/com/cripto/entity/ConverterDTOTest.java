package com.cripto.entity;

import com.cripto.entity.dto.CriptoValorCoinMktCap;
import com.cripto.util.ConverterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ConverterDTOTest {


    @Test
    public void coinMtkCapToEntityTest() throws JsonProcessingException {
        String response = "{\"data\":[{\"quote\":{\"USD\":{\"price\":35957.144434663925,\"volume_24h\":22208499250,\"market_cap\":684385813954}},\"slug\":\"bitcoin\"}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,
                true);
        CriptoValorCoinMktCap criptoValorCoinMktCap = objectMapper.readValue(response, CriptoValorCoinMktCap.class);
        List<CriptoValor> criptoValorList = ConverterDTO.listCoinMktCapToEntity(criptoValorCoinMktCap);
        CriptoValor criptoValor = criptoValorList.get(0);

        Assert.assertEquals("bitcoin", criptoValorCoinMktCap.getData().get(0).getId());
        Assert.assertEquals("bitcoin", criptoValor.getId());

    }
}
