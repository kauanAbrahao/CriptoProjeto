package com.cripto.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriptomoedaDTO {

    private String id;
    private String symbol;
    private String name;
    private int mkt_cap_rank;
}
