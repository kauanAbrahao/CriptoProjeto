package com.example.CriptoProjeto.entity;

import java.time.LocalDateTime;

public class CriptoValor {

    private String id;
    private int current_price;
    private int market_cap;
    private int total_volume;
    private LocalDateTime data_hr;

    public CriptoValor(String id, int current_price, int market_cap, int total_volume, LocalDateTime data_hr) {
        this.id = id;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.total_volume = total_volume;
        this.data_hr = data_hr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public int getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(int market_cap) {
        this.market_cap = market_cap;
    }

    public int getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(int total_volume) {
        this.total_volume = total_volume;
    }

    public LocalDateTime getData_hr() {
        return data_hr;
    }

    public void setData_hr(LocalDateTime data_hr) {
        this.data_hr = data_hr;
    }
}
