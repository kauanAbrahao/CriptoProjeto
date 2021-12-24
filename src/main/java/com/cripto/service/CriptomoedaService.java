package com.cripto.service;

import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptomoedaDTO;
import com.cripto.repository.CriptomoedaRepository;
import com.cripto.util.ConverterDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CriptomoedaService {

    @Autowired
    CriptomoedaRepository criptoRepo;

    public ResponseEntity<List<CriptomoedaDTO>> getAll(){
        Optional<List<Criptomoeda>> criptomoedas = Optional.ofNullable(criptoRepo.buscarCriptomoedas());

        if(criptomoedas.isPresent() && !criptomoedas.get().isEmpty()){
            List<CriptomoedaDTO> response = ConverterDTO.entityToDTO(criptomoedas.get());
            return ResponseEntity.ok(response);
        }

        throw new RuntimeException("Falha ao buscar criptomoedas");

    }
}
