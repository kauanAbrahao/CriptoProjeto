package com.example.CriptoProjeto.entity.dto;

import com.example.CriptoProjeto.entity.CriptoValor;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;


public class CriptoValorDTO {

    private String id;
    private BigDecimal current_price;
    private Long market_cap;
    private BigDecimal total_volume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(BigDecimal current_price) {
        this.current_price = current_price;
    }

    public Long getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Long market_cap) {
        this.market_cap = market_cap;
    }

    public BigDecimal getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(BigDecimal total_volume) {
        this.total_volume = total_volume;
    }

    public CriptoValorDTO convertoToDTO(CriptoValor criptoValor){
        CriptoValorDTO criptoValorDTO = new CriptoValorDTO();
        criptoValorDTO.setId(criptoValor.getId());
        criptoValorDTO.setCurrent_price(criptoValor.getCurrentPrice());
        criptoValorDTO.setTotal_volume(criptoValor.getTotalVolume());
        criptoValorDTO.setMarket_cap(criptoValor.getMktCap());
        return criptoValorDTO;
    }
}
