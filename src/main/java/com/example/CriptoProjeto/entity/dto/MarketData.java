package com.example.CriptoProjeto.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData {

    @JsonProperty("current_price")
    private CurrentPrice currentPrice;

    @JsonProperty("market_cap")
    private MarketCap marketCap;

    @JsonProperty("total_volume")
    private TotalVolume totalVolume;

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    public MarketCap getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(MarketCap marketCap) {
        this.marketCap = marketCap;
    }

    public TotalVolume getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(TotalVolume totalVolume) {
        this.totalVolume = totalVolume;
    }
}
