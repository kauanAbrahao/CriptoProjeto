package com.example.CriptoProjeto.entity;

public enum EnumCripto {

    BITCOIN("bitcoin","btc","Ethereum"),
    ETHEREUM("ethereum","eth","Ethereum");

    private String id;
    private String symbol;
    private String name;

    EnumCripto(String id, String symbol, String name) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }




}
