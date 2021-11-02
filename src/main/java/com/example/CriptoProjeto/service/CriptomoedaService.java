package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.entity.dto.CriptomoedaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriptomoedaService {

    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";

    @Autowired
    CriptomoedaDAOImpl criptomoedaDAO;

    public ResponseEntity<?> getAll(){
        return returnListOrNotFound(criptomoedaDAO.getAll());

    }

    private ResponseEntity<?> returnListOrNotFound(List<Criptomoeda> criptoList){
        if(criptoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            List<CriptomoedaDTO> criptomoedaDTOList = new ArrayList<>();
            for(Criptomoeda criptomoeda: criptoList){
                CriptomoedaDTO criptomoedaDTO = new CriptomoedaDTO();
                criptomoedaDTO.setId(criptomoeda.getId());
                criptomoedaDTO.setName(criptomoeda.getName());
                criptomoedaDTO.setSymbol(criptomoeda.getSymbol());
                criptomoedaDTO.setMkt_cap_rank(criptomoeda.getMktCapRank());
                criptomoedaDTOList.add(criptomoedaDTO);
            }
            return ResponseEntity.ok(criptomoedaDTOList);
        }
    }
}
