package com.example.CriptoProjeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Criptomoeda2 {

    private String idCripto;

    private String simbolo;

    private String nome;

    private LocalDate requestDate;

    public Criptomoeda2(
            @JsonProperty("id") String id,
            @JsonProperty("symbol") String simbolo,
            @JsonProperty("name") String nome){

        this.idCripto = id;
        this.simbolo = simbolo;
        this.nome = nome;
        this.requestDate = LocalDate.now();
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getIdCripto() {
        return idCripto;
    }

    public void setIdCripto(String idCripto) {
        this.idCripto = idCripto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }


    @Override
    public String toString() {
        return "Criptomoeda2{" +
                "idCripto='" + idCripto + '\'' +
                ", nome='" + nome + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}
