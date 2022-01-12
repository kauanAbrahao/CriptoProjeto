package com.cripto.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CriptoValorHistDTO {

    private String id;
    private BigDecimal open_price;
    private BigDecimal avg_price;
    private BigDecimal close_price;
    private BigDecimal high_price;
    private BigDecimal low_price;
    private Long open_mkt_cap;
    private Long close_mkt_cap;
    private BigDecimal avg_mkt_cap;
    private Long total_volume;
    private LocalDate reference_date;

}
