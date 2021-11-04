package com.example.CriptoProjeto.service;

import com.example.CriptoProjeto.dao.CriptoValorHistDAOImpl;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.apache.tomcat.jni.Local;
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

    public ResponseEntity<?> getCriptoValorDatePorId(String idCripto, String dataRef) {
        try {
            LocalDate dtRef = LocalDate.parse(dataRef);
            if(!dtRef.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistDAO.getIdDate(idCripto, dtRef));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getCriptoValorRangeDate(String dataInicial, String dataFim) {
        try {
            LocalDate dtInicial = LocalDate.parse(dataInicial);
            LocalDate dtFim = LocalDate.parse(dataFim);
            if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistDAO.getRangeDate(dtInicial, dtFim));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getCriptoValorRangeDateId(String dataInicial, String dataFim, String idCripto) {
        try {
            LocalDate dtInicial = LocalDate.parse(dataInicial);
            LocalDate dtFim = LocalDate.parse(dataFim);
            if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistDAO.getRangeDateId(dtInicial, dtFim, idCripto));
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
