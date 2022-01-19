package com.cripto.service;

import com.cripto.entity.CriptoValor;
import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.repository.CriptoValorRepository;
import com.cripto.util.ConverterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CriptoValorService {

    @Autowired
    CriptoValorRepository criptoValorRespository;

    @Autowired
    CriptoValorRepository criptoValorRepository;

    @Autowired
    RequestService requestService;

    public ResponseEntity<List<CriptoValorDTO>> buscaTodasCriptoValor() {

        Optional<List<CriptoValor>> criptoValores = Optional.ofNullable(criptoValorRespository.getAll());

        if(criptoValores.isPresent() && !criptoValores.get().isEmpty()){
            List<CriptoValorDTO> response = ConverterDTO.entityToDTO(criptoValores.get());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.internalServerError().body(null);
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

    @Scheduled(fixedDelayString = ("${schedule.timeRequest}"))
    @Async
    public void valorAtualRequest(){
        try{
            var criptoValorList = requestService.criptoValorRequest();

            log.info("==> Iniciando GET valorAtualRequest");

            for(CriptoValor criptoValor : criptoValorList){
                criptoValorRespository.adicionarCriptoValor(criptoValor);
            }

            log.info("==> GET valorAtualRequest finalizado com sucesso");
        } catch (ResponseStatusException ex){
            log.error("==> FALHA GET valorAtualRequest: " + ex.getMessage(), ex.getCause());
        }
    }

}
