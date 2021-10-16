package com.example.CriptoProjeto.entity;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Criptomoeda {

    private String id;
    private String symbol;
    private String name;

    @SerializedName("market_cap_rank")
    private int mktCapRank;

    private CriptoValor criptoValor;
    private LocalDateTime dthrInclusao;

    public Criptomoeda(){}

    public Criptomoeda(String id, String symbol, String name, int market_cap_rank, CriptoValor valor) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.mktCapRank = market_cap_rank;
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

    public int getMktCapRank() {
        return mktCapRank;
    }

    public void setMktCapRank(int mktCapRank) {
        this.mktCapRank = mktCapRank;
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
                ", market_cap_rank=" + mktCapRank +
                ", criptoValor=" + criptoValor +
                '}';
    }
}
