package com.cripto.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriptoExtremoDTO {

    private String id;
    private Double high_value_day;
    private Double low_value_day;
    private LocalDate reference_date;
}
