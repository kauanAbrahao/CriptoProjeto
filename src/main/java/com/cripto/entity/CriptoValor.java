package com.cripto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CriptoValor {

    private String id;

    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty("market_cap")
    private Long mktCap;

    @JsonProperty("total_volume")
    private BigDecimal totalVolume;

    private LocalDateTime dthrInclusao;

}
