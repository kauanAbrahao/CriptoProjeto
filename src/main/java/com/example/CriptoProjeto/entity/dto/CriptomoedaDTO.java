package com.example.CriptoProjeto.entity.dto;

public class CriptomoedaDTO {

    private String id;
    private String symbol;
    private String name;
    private int mkt_cap_rank;


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

    public int getMkt_cap_rank() {
        return mkt_cap_rank;
    }

    public void setMkt_cap_rank(int mkt_cap_rank) {
        this.mkt_cap_rank = mkt_cap_rank;
    }
}
