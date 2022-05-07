package com.cripto.service.contracts;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;

import java.util.List;

public interface CoinRequest {

    List<CriptoExtremo>  criptoExtremosRequest();
    List<CriptoValor> criptoValorRequest();
    List<Criptomoeda> criptoValorMktRankRequest();
}
