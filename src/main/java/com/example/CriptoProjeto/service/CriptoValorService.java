package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptoValorDAOImpl;
import com.example.CriptoProjeto.dao.CriptoValorHistDAOImpl;
import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.dao.rowmapper.CriptoValorHistRowMapper;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.DataFormatException;

@Service
public class CriptoValorService {

    final static String BAD_REQUEST = " {\"message\": \"invalid request\"} ";
    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";


    @Autowired
    CriptoValorDAOImpl criptoValorDAO;

    @Autowired
    CriptoValorHistDAOImpl criptoValorHistDAO;

    public ResponseEntity<?> getAllCriptoValor() {
        return this.returnListOrNotFound(criptoValorDAO.getAll());
    }

    public ResponseEntity<?> getCriptoValorPorId(String idCriptoValor) {
        return this.returnObjectOrNotFound(criptoValorDAO.getPorId(idCriptoValor));

    }

    public ResponseEntity<?> getCriptoValorListPorRank(Integer mktRank) {
        return this.returnListOrNotFound(criptoValorDAO.getCriptoValorListPorRank(mktRank));
    }



    private ResponseEntity<?> returnListOrNotFound(List<CriptoValor> criptoList){
        if(criptoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            List<CriptoValorDTO> criptoValorDTOList = new ArrayList<>();
            for(CriptoValor criptoValor: criptoList){
                CriptoValorDTO criptoValorDTO = new CriptoValorDTO();
                criptoValorDTO = criptoValorDTO.convertoToDTO(criptoValor);
                criptoValorDTOList.add(criptoValorDTO);
            }
            return ResponseEntity.ok(criptoValorDTOList);
        }
    }

    private ResponseEntity<?> returnObjectOrNotFound(CriptoValor criptoValor){
        if(Objects.isNull(criptoValor)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
        else{
            return ResponseEntity.ok(new CriptoValorDTO().convertoToDTO(criptoValor));
        }
    }

}
