package com.cripto.service;

import com.cripto.entity.CriptoValor;
import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.repository.CriptoValorRepository;
import com.cripto.util.ConverterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CriptoValorService {

    final CriptoValorRepository criptoValorRespository;

    final CriptoValorRepository criptoValorRepository;

    final CoinGeckoRequestService coinGeckoRequestService;

    final CoinMktCapRequestService coinMktCapRequestService;

    public CriptoValorService(CriptoValorRepository criptoValorRespository, CriptoValorRepository criptoValorRepository, CoinGeckoRequestService coinGeckoRequestService, CoinMktCapRequestService coinMktCapRequestService) {
        this.criptoValorRespository = criptoValorRespository;
        this.criptoValorRepository = criptoValorRepository;
        this.coinGeckoRequestService = coinGeckoRequestService;
        this.coinMktCapRequestService = coinMktCapRequestService;
    }

    public List<CriptoValorDTO> buscaTodasCriptoValor() {

        Optional<List<CriptoValor>> criptoValores = Optional.ofNullable(criptoValorRespository.getAll());

        if(criptoValores.isPresent() && !criptoValores.get().isEmpty()){
            return ConverterDTO.entityToDTO(criptoValores.get());
        }

        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    public ResponseEntity<CriptoValorDTO> getCriptoValorPorId(String idCriptoValor) {

        CriptoValor criptoValor = criptoValorRespository.getPorId(idCriptoValor);

        if(Objects.isNull(criptoValor)){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Criptomoeda não encontrada");
        }

        return ResponseEntity.ok(ConverterDTO.entityToDTO(criptoValor));
    }

    public ResponseEntity<List<CriptoValorDTO>> getCriptoValorListPorRank(Integer mktCapRank) {
        var criptoValorListPorRank = criptoValorRespository.getCriptoValorListPorRank(mktCapRank);

        if (criptoValorListPorRank.isEmpty()){
            return ResponseEntity.internalServerError().build();
        }

        var result = ConverterDTO.entityToDTO(criptoValorListPorRank);
        result.sort(Comparator.comparing(CriptoValorDTO::getMarket_cap).reversed());

        return ResponseEntity.ok(result);
    }

//    @Scheduled(fixedDelayString = ("${schedule.timeRequest}"))
    @Async
    public void valorAtualRequest(){
        try{
            var criptoValorList = coinGeckoRequestService.criptoValorRequest();
            coinMktCapRequestService.criptoValorRequest();

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
