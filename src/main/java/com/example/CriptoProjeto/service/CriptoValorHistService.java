package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptoValorHistDAOImpl;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriptoValorHistService {

    @Autowired
    CriptoValorHistDAOImpl criptoValorHistDAO;

    final static String BAD_REQUEST = " {\"message\": \"invalid request\"} ";
    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";

    public ResponseEntity<?> getAllCriptoValorDate(String dataRef) {
        try {
            LocalDate dtRef = LocalDate.parse(dataRef);
            if(!dtRef.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistDAO.getAllDate(dtRef));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    private ResponseEntity<?> returnListOrNotFound(List<CriptoValorHistDTO> criptoList){
        if(criptoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            return ResponseEntity.ok(criptoList);
        }
    }

}
