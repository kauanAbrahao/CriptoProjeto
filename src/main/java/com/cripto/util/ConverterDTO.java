package com.cripto.util;

import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptoValorCoinMktCap;
import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.entity.dto.CriptomoedaDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterDTO {

    public static CriptomoedaDTO entityToDTO(Criptomoeda criptomoeda){
        return new CriptomoedaDTO(criptomoeda.getId(), criptomoeda.getSymbol(),
                                  criptomoeda.getName(), criptomoeda.getMktCapRank());
    }

    public static List<CriptomoedaDTO> listEntityToListDTO(List<Criptomoeda> criptomoedas){
        return criptomoedas.stream().map(criptomoeda -> new CriptomoedaDTO(criptomoeda.getId(), criptomoeda.getSymbol(),
                criptomoeda.getName(), criptomoeda.getMktCapRank())).collect(Collectors.toList());
    }

    public static List<CriptoValorDTO> entityToDTO(List<CriptoValor> criptoValores){
        return criptoValores.stream().map(valores -> new CriptoValorDTO(valores.getId(), valores.getCurrentPrice(),
                valores.getMktCap(), valores.getTotalVolume(), valores.getDthrInclusao().truncatedTo(ChronoUnit.MINUTES))).collect(Collectors.toList());
    }

    public static CriptoValorDTO entityToDTO(CriptoValor criptoValor){
        return new CriptoValorDTO(criptoValor.getId(), criptoValor.getCurrentPrice(),
                criptoValor.getMktCap(), criptoValor.getTotalVolume(), criptoValor.getDthrInclusao().truncatedTo(ChronoUnit.MINUTES));
    }


    public static List<CriptoValor> listCoinMktCapToEntity(CriptoValorCoinMktCap criptos){
        return criptos.getData().stream()
                .map(data ->
                        new CriptoValor(
                                data.getId(),
                                data.getQuote().getUsd().getPrice(),
                                data.getQuote().getUsd().getMarket_cap(),
                                data.getQuote().getUsd().getPrice(),
                                LocalDateTime.now()))
                .collect(Collectors.toList());
    }

}
