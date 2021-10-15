package com.example.CriptoProjeto.entity;

import java.time.LocalDateTime;

public class Criptomoeda {

    private String id;
    private String symbol;
    private String name;
    private int market_cap_rank;
    private CriptoValor criptoValor;
    private LocalDateTime data_hr;

    public Criptomoeda(){

    }
    public Criptomoeda(String id, String symbol, String name, int market_cap_rank, CriptoValor valor) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.market_cap_rank = market_cap_rank;
        this.criptoValor = valor;
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

    public CriptoValor getCriptoValor() {
        return criptoValor;
    }

    public void setCriptoValor(CriptoValor criptoValor) {
        this.criptoValor = criptoValor;
    }

    @Override
    public String toString() {
        return "Criptomoeda2{" +
                "id='" + id + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", market_cap_rank=" + market_cap_rank +
                ", criptoValor=" + criptoValor +
                '}';
    }
}
