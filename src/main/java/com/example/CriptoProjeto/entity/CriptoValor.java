package com.example.CriptoProjeto.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CriptoValor {

    private String id;
    private BigDecimal current_price;
    private Long market_cap;
    private Long total_volume;
    private LocalDateTime data_hr;

    public CriptoValor(String id, BigDecimal current_price, Long market_cap, Long total_volume, LocalDateTime data_hr) {
        this.id = id;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.total_volume = total_volume;
        this.data_hr = data_hr;
    }

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

    public Long getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Long total_volume) {
        this.total_volume = total_volume;
    }

    public LocalDateTime getData_hr() {
        return data_hr;
    }

    public void setData_hr(LocalDateTime data_hr) {
        this.data_hr = data_hr;
    }

    @Override
    public String toString() {
        return "CriptoValor{" +
                "id='" + id + '\'' +
                ", current_price=" + current_price +
                ", market_cap=" + market_cap +
                ", total_volume=" + total_volume +
                ", data_hr=" + data_hr +
                '}';
    }
}
