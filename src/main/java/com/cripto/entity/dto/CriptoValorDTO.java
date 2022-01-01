package com.cripto.entity.dto;

import com.cripto.entity.CriptoValor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CriptoValorDTO {

    private String id;
    private BigDecimal current_price;
    private Long market_cap;
    private BigDecimal total_volume;

}
