package com.example.CriptoProjeto.entity.dto;

import java.time.LocalDate;

public class CriptoExtremoDTO {

    private String id;
    private Double high_value_day;
    private Double low_value_day;
    private LocalDate reference_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getHigh_value_day() {
        return high_value_day;
    }

    public void setHigh_value_day(Double high_value_day) {
        this.high_value_day = high_value_day;
    }

    public Double getLow_value_day() {
        return low_value_day;
    }

    public void setLow_value_day(Double low_value_day) {
        this.low_value_day = low_value_day;
    }

    public LocalDate getReference_date() {
        return reference_date;
    }

    public void setReference_date(LocalDate reference_date) {
        this.reference_date = reference_date;
    }
}
