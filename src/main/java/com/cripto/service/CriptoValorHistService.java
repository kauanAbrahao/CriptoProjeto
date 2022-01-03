package com.cripto.service;

import com.cripto.repository.CriptoValorHistRepository;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CriptoValorHistService {

    @Autowired
    CriptoValorHistRepository criptoValorHistRepository;

    private final String NOT_FOUND_BODY = "Not found for given date";
    private final String BAD_REQUEST = "Invalid Reference Date";

    public ResponseEntity<?> getAllCriptoValorDate(LocalDate dtRef) {
        try {
            if(!dtRef.isBefore(LocalDate.now())){
                return ResponseEntity.badRequest().body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistRepository.getAllDate(dtRef));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getCriptoValorDatePorId(String idCripto, LocalDate dtRef) {
        try {
            if(!dtRef.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistRepository.getIdDate(idCripto, dtRef));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getCriptoValorRangeDate(LocalDate dtInicial, LocalDate dtFim) {
        try {
            if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistRepository.getRangeDate(dtInicial, dtFim));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getCriptoValorRangeDateId(LocalDate dtInicial, LocalDate dtFim, String idCripto) {
        try {
            if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
            }
            return returnListOrNotFound(criptoValorHistRepository.getRangeDateId(dtInicial, dtFim, idCripto));
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
