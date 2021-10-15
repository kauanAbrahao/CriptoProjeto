package com.example.CriptoProjeto.entity;

import java.time.LocalDateTime;

public class Criptomoeda2 {

    private String id;
    private String symbol;
    private String name;
    private int market_cap_rank;
    private CriptoValor valor;
    private LocalDateTime data_hr;

    public Criptomoeda2(){

    }
    public Criptomoeda2(String id, String symbol, String name, int market_cap_rank, CriptoValor valor) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.market_cap_rank = market_cap_rank;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(int market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }

    public CriptoValor getValor() {
        return valor;
    }

    public void setValor(CriptoValor valor) {
        this.valor = valor;
    }


}
