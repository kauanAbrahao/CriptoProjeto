package com.cripto.entity;

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
public class Criptomoeda {

    private String id;
    private String symbol;
    private String name;

    @SerializedName("market_cap_rank")
    private Integer mktCapRank;

    private CriptoValor criptoValor;
    private LocalDateTime dthrInclusao;
}
