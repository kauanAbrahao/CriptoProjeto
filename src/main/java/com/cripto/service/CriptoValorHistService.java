package com.cripto.service;

import com.cripto.repository.CriptoValorHistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class CriptoValorHistService {

    @Autowired
    CriptoValorHistRepository criptoValorHistRepository;

    public ResponseEntity<?> getAllCriptoValorDate(LocalDate dtRef) {
        if(!dtRef.isBefore(LocalDate.now())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var criptoExtremoDTOList = criptoValorHistRepository.getAllDate(dtRef);

        if(criptoExtremoDTOList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return  ResponseEntity.ok(criptoExtremoDTOList);

    }

    public ResponseEntity<?> getCriptoValorDatePorId(String idCripto, LocalDate dtRef) {
        if(!dtRef.isBefore(LocalDate.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var criptoValorList = criptoValorHistRepository.getIdDate(idCripto, dtRef);

        if(criptoValorList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoValorList);
    }

    public ResponseEntity<?> getCriptoValorRangeDate(LocalDate dtInicial, LocalDate dtFim) {
        if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var criptoValorList = criptoValorHistRepository.getRangeDate(dtInicial, dtFim);

        if(criptoValorList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoValorList);
    }

    public ResponseEntity<?> getCriptoValorRangeDateId(LocalDate dtInicial, LocalDate dtFim, String idCripto) {

        if(!dtInicial.isBefore(LocalDate.now()) || !dtFim.isBefore(LocalDate.now())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var criptoValorList = criptoValorHistRepository.getRangeDateId(dtInicial, dtFim, idCripto);

        if(criptoValorList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoValorList);

    }

}
