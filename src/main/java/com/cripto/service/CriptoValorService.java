package com.cripto.service;

import com.cripto.repository.CriptoValorRepository;
import com.cripto.util.ConverterDTO;
import com.example.CriptoProjeto.dao.CriptoValorHistDAOImpl;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.dto.CriptoValorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CriptoValorService {

    @Autowired
    CriptoValorRepository criptoValorRespository;

    @Autowired
    CriptoValorRepository criptoValorRepository;

    public ResponseEntity<List<CriptoValorDTO>> buscaTodasCriptoValor() {

        Optional<List<CriptoValor>> criptoValores = Optional.ofNullable(criptoValorRespository.getAll());
        if(criptoValores.isPresent() && !criptoValores.get().isEmpty()){
            List<CriptoValorDTO> response = ConverterDTO.entityToDTO(criptoValores.get());
            return ResponseEntity.ok(response);
        }

        throw new RuntimeException("Falha ao buscar CriptoValores");
    }

    public ResponseEntity<CriptoValorDTO> getCriptoValorPorId(String idCriptoValor) {

        CriptoValor criptoValor = criptoValorRespository.getPorId(idCriptoValor);
        if(Objects.isNull(criptoValor)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ConverterDTO.entityToDTO(criptoValor));
    }

    public ResponseEntity<List<CriptoValorDTO>> getCriptoValorListPorRank(Integer mktCapRank) {
        var criptoValorListPorRank = criptoValorRespository.getCriptoValorListPorRank(mktCapRank);
        if (criptoValorListPorRank.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ConverterDTO.entityToDTO(criptoValorListPorRank));
    }

}
