package com.cripto.util;

import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptomoedaDTO;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterDTO {

    public static CriptomoedaDTO entityToDTO(Criptomoeda criptomoeda){
        return new CriptomoedaDTO(criptomoeda.getId(), criptomoeda.getSymbol(),
                                  criptomoeda.getName(), criptomoeda.getMktCapRank());
    }

    public static List<CriptomoedaDTO> entityToDTO(List<Criptomoeda> criptomoedas){
        return criptomoedas.stream().map(criptomoeda -> new CriptomoedaDTO(criptomoeda.getId(), criptomoeda.getSymbol(),
                criptomoeda.getName(), criptomoeda.getMktCapRank())).collect(Collectors.toList());
    }

}
