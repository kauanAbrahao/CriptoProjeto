package com.cripto.entity.dto;

import com.cripto.entity.CriptoValor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CriptoValorDTO {

    private String id;
    private BigDecimal current_price;
    private Long market_cap;
    private BigDecimal total_volume;
    private LocalDateTime datetime_reference;

}
