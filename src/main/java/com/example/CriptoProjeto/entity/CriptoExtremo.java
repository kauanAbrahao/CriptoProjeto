package com.example.CriptoProjeto.entity;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class CriptoExtremo {

    @SerializedName("id")
    String id;

    @SerializedName("high_24h")
    Double highValueDay;

    @SerializedName("low_24h")
    Double lowValueDay;

    LocalDateTime dthrInclusao;

    public CriptoExtremo(){}


    public CriptoExtremo(String id, Double high_24h, Double low_24h, LocalDateTime data_hr) {
        this.id = id;
        this.highValueDay = high_24h;
        this.lowValueDay = low_24h;
        this.dthrInclusao = data_hr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getHighValueDay() {
        return highValueDay;
    }

    public void setHighValueDay(Double highValueDay) {
        this.highValueDay = highValueDay;
    }

    public Double getLowValueDay() {
        return lowValueDay;
    }

    public void setLowValueDay(Double lowValueDay) {
        this.lowValueDay = lowValueDay;
    }

    public LocalDateTime getDthrInclusao() {
        return dthrInclusao;
    }

    public void setDthrInclusao(LocalDateTime dthrInclusao) {
        this.dthrInclusao = dthrInclusao;
    }

    @Override
    public String toString() {
        return "CriptoExtremo{" +
                "id='" + id + '\'' +
                ", high_24h=" + highValueDay +
                ", low_24h=" + lowValueDay +
                ", data_hr=" + dthrInclusao +
                '}';
    }
}
