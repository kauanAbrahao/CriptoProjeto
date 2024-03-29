package com.cripto.service;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.dto.CriptoExtremoDTO;
import com.cripto.repository.CriptoExtremoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CriptoExtremoService {

    final CriptoExtremoRepository criptoRepo;

    final CoinGeckoRequestService coinGeckoRequestService;

    public CriptoExtremoService(CriptoExtremoRepository criptoRepo, CoinGeckoRequestService coinGeckoRequestService) {
        this.criptoRepo = criptoRepo;
        this.coinGeckoRequestService = coinGeckoRequestService;
    }

    public ResponseEntity<List<CriptoExtremoDTO>> getAll(LocalDate dtRef) {

        if(!dtRef.isBefore(LocalDate.now())){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data informada não deve ser futura");
        }

        List<CriptoExtremoDTO> criptoExtremoDTOList = criptoRepo.getAllCriptoExtremo(dtRef);

        if(criptoExtremoDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoExtremoDTOList);

    }

    public ResponseEntity<CriptoExtremoDTO> getById(LocalDate dtRef, String idCripto) {

        if(!dtRef.isBefore(LocalDate.now())){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data informada não deve ser futura");
        }

        CriptoExtremoDTO criptoExtremoDTO = criptoRepo.getCriptoExtremoById(dtRef, idCripto);

        if(Objects.isNull(criptoExtremoDTO)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(criptoExtremoDTO);
    }

    /**
     * Método que roda ao final do dia, persistindo o high_24h e low_24h de cada criptomoeda
     */
    @Scheduled(cron = ("${schedule.cronExtremo}"))
    @Async
    public void valoresExtremosFinalDoDia(){
        try {
            log.info("==> Iniciada Atualização TAB_EXTREMOS ");
            var criptoExtremosList = coinGeckoRequestService.criptoExtremosRequest();
            for(CriptoExtremo criptoExtremo: criptoExtremosList){
                criptoRepo.adicionarCriptoExtremo(criptoExtremo);
            }
            log.info("==> Atualização TAB_EXTREMOS finalizada com sucesso");
        } catch (Exception ex){
            log.error("==> Erro na atualização TAB_EXTREMOS :" + ex.getMessage(), ex.getCause());
        }
    }
}
