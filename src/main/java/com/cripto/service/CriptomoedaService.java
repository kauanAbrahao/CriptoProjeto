package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptomoedaDTO;
import com.cripto.repository.CriptomoedaRepository;
import com.cripto.util.ConverterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CriptomoedaService {

    @Autowired
    CriptomoedaRepository criptoRepo;

    @Autowired
    RequestService requestService;


    public ResponseEntity<List<CriptomoedaDTO>> getAll(){
        Optional<List<Criptomoeda>> criptomoedas = Optional.ofNullable(criptoRepo.buscarCriptomoedas());

        if(criptomoedas.isPresent() && !criptomoedas.get().isEmpty()){
            List<CriptomoedaDTO> response = ConverterDTO.listEntityToListDTO(criptomoedas.get());
            return ResponseEntity.ok(response);
        }

        throw new RuntimeException("Falha ao buscar criptomoedas");

    }

    @Scheduled(fixedDelayString = ("${schedule.timeRequest}"))
    @Async
    public void valorAtualRequest(){
        try{
            var criptoValorList = requestService.criptoValorRequest();

            log.info("Iniciando Request criptoValor");

            for(CriptoValor criptoValor : criptoValorList){
                criptoRepo.adicionarCriptoValor(criptoValor);
            }

            log.info("Request criptoValor: " + LocalDateTime.now());
        } catch (ResponseStatusException ex){
            log.error("Request criptoValor ERROR: " + ex.getMessage(), ex.getCause());
        }
    }

    @Scheduled(cron = ("${schedule.cron}"))
    @Async
    public void valoresExtremosFinalDoDia(){
        try {
            var criptoExtremosList = requestService.criptoExtremosRequest();
            for(CriptoExtremo criptoExtremo: criptoExtremosList){
                criptoRepo.adicionarCriptoExtremo(criptoExtremo);
            }
            log.info("Atualização com sucesso TAB_EXTREMOS. Horário ==> " + LocalDateTime.now());
        } catch (Exception ex){
            log.error(ex.getMessage(), ex.getCause());
        }
    }

    @Scheduled(fixedDelayString = ("${schedule.timeRequest}"))
    @Async
    public void atualizaMktRankCriptomoedas(){
        log.info("atualizarMktRankCriptomoedas iniciado");
        try{
            var criptomoedaList = requestService.criptoValorMktRankRequest();
            for(Criptomoeda criptomoeda : criptomoedaList){
                criptoRepo.atualizarMktRankCrpiptomoedas(criptomoeda);
            }

            log.info("atualizarMktRankCriptomoedas concluído com sucesso!");
        } catch (Exception e){
            log.error("Erro no atualizarMktRankCriptomoedas ==>" + e.getMessage(), e.getCause());
        }
    }
}
