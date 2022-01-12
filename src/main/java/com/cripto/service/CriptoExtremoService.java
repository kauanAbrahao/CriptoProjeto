package com.cripto.service;

import com.cripto.entity.dto.CriptoExtremoDTO;
import com.cripto.repository.CriptoExtremoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CriptoExtremoService {

    @Autowired
    CriptoExtremoRepository criptoRepo;

    public ResponseEntity<List<CriptoExtremoDTO>> getAll(LocalDate dtRef) {

        if(!dtRef.isBefore(LocalDate.now())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<CriptoExtremoDTO> criptoExtremoDTOList = criptoRepo.getAllCriptoExtremo(dtRef);

        if(criptoExtremoDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoExtremoDTOList);

    }
}
