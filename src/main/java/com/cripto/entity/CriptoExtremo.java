package com.cripto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CriptoExtremo {

    @JsonProperty("id")
    String id;

    @JsonProperty("high_24h")
    Double highValueDay;

    @JsonProperty("low_24h")
    Double lowValueDay;
}