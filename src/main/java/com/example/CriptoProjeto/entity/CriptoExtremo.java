package com.example.CriptoProjeto.entity;

import java.time.LocalDateTime;

public class CriptoExtremo {

    String id;
    Double high_24h;
    Double low_24h;
    LocalDateTime data_hr;


    public CriptoExtremo(String id, Double high_24h, Double low_24h, LocalDateTime data_hr) {
        this.id = id;
        this.high_24h = high_24h;
        this.low_24h = low_24h;
        this.data_hr = data_hr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getHigh_24h() {
        return high_24h;
    }

    public void setHigh_24h(Double high_24h) {
        this.high_24h = high_24h;
    }

    public Double getLow_24h() {
        return low_24h;
    }

    public void setLow_24h(Double low_24h) {
        this.low_24h = low_24h;
    }

    public LocalDateTime getData_hr() {
        return data_hr;
    }

    public void setData_hr(LocalDateTime data_hr) {
        this.data_hr = data_hr;
    }
}
