package com.cripto.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class CriptoExtremo {

    @SerializedName("id")
    String id;

    @SerializedName("high_24h")
    Double highValueDay;

    @SerializedName("low_24h")
    Double lowValueDay;

    LocalDateTime dthrInclusao;

    public CriptoExtremo(String id, Double high_24h, Double low_24h, LocalDateTime data_hr) {
        this.id = id;
        this.highValueDay = high_24h;
        this.lowValueDay = low_24h;
        this.dthrInclusao = data_hr;
    }
}