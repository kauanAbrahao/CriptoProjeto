package com.cripto.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
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

    @JsonAlias({"current_price", "price"})
    private BigDecimal currentPrice;

    @JsonProperty("market_cap")
    private Long mktCap;

    @JsonAlias({"total_volume", "volume_24"})
    private BigDecimal totalVolume;

    private LocalDateTime dthrInclusao;

}
