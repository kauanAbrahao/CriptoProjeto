package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptoExtremoDAOImpl;
import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.dto.CriptoExtremoDTO;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CriptoExtremoService {

    @Autowired
    CriptoExtremoDAOImpl criptoExtremoDAO;

    final static String BAD_REQUEST = " {\"message\": \"invalid request\"} ";
    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";

    public ResponseEntity<?> getAll(String dataRef) {
        try {
            LocalDate dtRef = LocalDate.parse(dataRef);
            if(!dtRef.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoExtremoDAO.getAll(dtRef.toString()));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }

    }

    private ResponseEntity<?> returnListOrNotFound(List<CriptoExtremoDTO> criptoList){
        if(criptoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            return ResponseEntity.ok(criptoList);
        }
    }
}
