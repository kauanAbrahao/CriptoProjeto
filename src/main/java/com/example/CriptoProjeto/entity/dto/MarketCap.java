package com.example.CriptoProjeto.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketCap {

    @JsonProperty("brl")
    private String brl;

    public String getBrl() {
        return brl;
    }

    public void setBrl(String brl) {
        this.brl = brl;
    }
}
