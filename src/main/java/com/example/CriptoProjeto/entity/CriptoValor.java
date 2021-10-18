package com.example.CriptoProjeto.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CriptoValor {

    private String id;

    @SerializedName("current_price")
    private BigDecimal currentPrice;

    @SerializedName("market_cap")
    private Long mktCap;

    @SerializedName("total_volume")
    private BigDecimal totalVolume;

    private LocalDateTime dthrInclusao;

    public CriptoValor(){}

    public CriptoValor(String id, BigDecimal current_price, Long market_cap, BigDecimal total_volume, LocalDateTime data_hr) {
        this.id = id;
        this.currentPrice = current_price;
        this.mktCap = market_cap;
        this.totalVolume = total_volume;
        this.dthrInclusao = data_hr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getMktCap() {
        return mktCap;
    }

    public void setMktCap(Long mktCap) {
        this.mktCap = mktCap;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public LocalDateTime getDthrInclusao() {
        return dthrInclusao;
    }

    public void setDthrInclusao(LocalDateTime dthrInclusao) {
        this.dthrInclusao = dthrInclusao;
    }

    @Override
    public String toString() {
        return "CriptoValor{" +
                "id='" + id + '\'' +
                ", current_price=" + currentPrice +
                ", market_cap=" + mktCap +
                ", total_volume=" + totalVolume +
                ", data_hr=" + dthrInclusao +
                '}';
    }
}
