package com.cripto.service;

import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptomoedaDTO;
import com.cripto.repository.CriptomoedaRepository;
import com.cripto.util.ConverterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CriptomoedaService {

    @Autowired
    CriptomoedaRepository criptoRepo;

    @Autowired
    CoinGeckoRequestService coinGeckoRequestService;


    public ResponseEntity<List<CriptomoedaDTO>> getAll(){
        Optional<List<Criptomoeda>> criptomoedas = Optional.ofNullable(criptoRepo.buscarCriptomoedas());

        if(criptomoedas.isPresent() && !criptomoedas.get().isEmpty()){
            List<CriptomoedaDTO> response = ConverterDTO.listEntityToListDTO(criptomoedas.get());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.internalServerError().body(null);

    }

    public ResponseEntity<?> getPorId(String idCriptomoeda) {
        Criptomoeda criptomoeda = criptoRepo.buscarCriptomoedaPorId(idCriptomoeda);

        if(Objects.isNull(criptomoeda)){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Criptomoeda não encontrada");
        }

        return ResponseEntity.ok(criptomoeda);
    }

    /**
     * Método que roda ao final do dia, atualizando o MktCapRank de todas as criptomoedas
     */
    @Scheduled(cron = ("${schedule.cron}"))
    @Async
    public void atualizaMktRankCriptomoedas(){
        log.info("==> Iniciando atualizarMktRankCriptomoedas");
        try{
            var criptomoedaList = coinGeckoRequestService.criptoValorMktRankRequest();
            for(Criptomoeda criptomoeda : criptomoedaList){
                criptoRepo.atualizarMktRankCrpiptomoedas(criptomoeda);
            }

            log.info("==> atualizarMktRankCriptomoedas finalizado com sucesso");
        } catch (Exception e){
            log.error("==> Erro no atualizarMktRankCriptomoedas " + e.getMessage(), e.getCause());
        }
    }
}
