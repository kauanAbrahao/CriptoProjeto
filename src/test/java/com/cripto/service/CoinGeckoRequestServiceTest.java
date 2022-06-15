package com.cripto.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@RunWith(MockitoJUnitRunner.class)
public class CoinGeckoRequestServiceTest {

    private final String extremoUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";


    @Test
    public void getCriptoExtremoDaily(){
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        var response = testRestTemplate.getForEntity(extremoUrl, String.class);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
