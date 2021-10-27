package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptoValorDAOImpl;
import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CriptoValorService {

    @Autowired
    CriptoValorDAOImpl criptoValorDAO;

    public List<CriptoValorDTO> getAllCriptoValor() {
        List<CriptoValor> criptoValorList = criptoValorDAO.getAll();
        List<CriptoValorDTO> criptoValorDTOList = new ArrayList<>();
        for(CriptoValor criptoValor: criptoValorList){
            CriptoValorDTO criptoValorDTO = new CriptoValorDTO();
            criptoValorDTO = criptoValorDTO.convertoToDTO(criptoValor);
            criptoValorDTOList.add(criptoValorDTO);
        }
        return criptoValorDTOList;
    }

    public CriptoValorDTO getCriptoValorPorId(String idCriptoValor) {
        CriptoValor criptoValor = criptoValorDAO.getPorId(idCriptoValor);
        if(Objects.isNull(criptoValor)){
            return null;
        }
        CriptoValorDTO criptoValorDTO = new CriptoValorDTO();
        return criptoValorDTO.convertoToDTO(criptoValor);
    }
}
