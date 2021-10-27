package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.dto.CriptomoedaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriptomoedaService {

    @Autowired
    CriptomoedaDAOImpl criptomoedaDAO;

    public List<CriptomoedaDTO> getAll(){
        List<Criptomoeda> criptomoedaList = criptomoedaDAO.getAll();
        List<CriptomoedaDTO> criptomoedaDTOList = new ArrayList<>();
        for (Criptomoeda criptomoeda : criptomoedaList){
            CriptomoedaDTO criptomoedaDTO = new CriptomoedaDTO();
            criptomoedaDTO.setId(criptomoeda.getId());
            criptomoedaDTO.setName(criptomoeda.getName());
            criptomoedaDTO.setSymbol(criptomoeda.getSymbol());
            criptomoedaDTO.setMkt_cap_rank(criptomoeda.getMktCapRank());
            criptomoedaDTOList.add(criptomoedaDTO);
        }
        return criptomoedaDTOList;

    }
}
