package com.cripto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Criptomoeda {

    private String id;
    private String symbol;
    private String name;

    @JsonProperty("market_cap_rank")
    private Integer mktCapRank;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dthrInclusao;
}
