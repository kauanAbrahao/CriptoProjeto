package com.cripto.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CriptoValorCoinMktCap {

    private List<Data> data;

    @Getter
    @Setter
    public static class Data{
        private Quote quote;
    }

    @Getter
    @Setter
    public static class Quote{
        @JsonProperty("USD")
        private USD usd;
    }

    @Getter
    @Setter
    public static class USD{
        private BigDecimal price;
        private Long volume_24h;
        private BigDecimal market_cap;
    }
}
