package com.example.CriptoProjeto.entity.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Component
public class CriptoValorHistDTO {

    private String id;
    private BigDecimal open_price;
    private BigDecimal avg_price;
    private BigDecimal close_price;
    private BigDecimal high_price;
    private BigDecimal low_price;
    private Long open_mkt_cap;
    private Long close_mkt_cap;
    private BigDecimal avg_mkt_cap;
    private BigInteger total_volume;
    private LocalDate reference_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getOpen_price() {
        return open_price;
    }

    public void setOpen_price(BigDecimal open_price) {
        this.open_price = open_price;
    }

    public BigDecimal getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(BigDecimal avg_price) {
        this.avg_price = avg_price;
    }

    public BigDecimal getClose_price() {
        return close_price;
    }

    public void setClose_price(BigDecimal close_price) {
        this.close_price = close_price;
    }

    public Long getOpen_mkt_cap() {
        return open_mkt_cap;
    }

    public void setOpen_mkt_cap(Long open_mkt_cap) {
        this.open_mkt_cap = open_mkt_cap;
    }

    public Long getClose_mkt_cap() {
        return close_mkt_cap;
    }

    public void setClose_mkt_cap(Long close_mkt_cap) {
        this.close_mkt_cap = close_mkt_cap;
    }

    public BigDecimal getAvg_mkt_cap() {
        return avg_mkt_cap;
    }

    public void setAvg_mkt_cap(BigDecimal avg_mkt_cap) {
        this.avg_mkt_cap = avg_mkt_cap;
    }

    public BigInteger getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(BigInteger total_volume) {
        this.total_volume = total_volume;
    }

    public LocalDate getReference_date() {
        return reference_date;
    }

    public void setReference_date(LocalDate reference_date) {
        this.reference_date = reference_date;
    }

    public BigDecimal getHigh_price() {
        return high_price;
    }

    public void setHigh_price(BigDecimal high_price) {
        this.high_price = high_price;
    }

    public BigDecimal getLow_price() {
        return low_price;
    }

    public void setLow_price(BigDecimal low_price) {
        this.low_price = low_price;
    }
}
