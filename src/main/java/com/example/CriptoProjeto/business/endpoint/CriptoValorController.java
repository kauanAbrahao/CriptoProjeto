package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.service.CriptoValorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Api(tags = {SwaggerConfig.CRIPTO_VALOR})
@RequestMapping("v1/api-criptovalor")
public class CriptoValorController {

    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";
    final static String BAD_REQUEST = " {\"message\": \"invalid id\"} ";
    final static String JSON = "application/json";
    final static String API_RESPONSE_BITCOIN = " {\"id\": \"bitcoin\", \"current_price\": 61089, \"market_cap\": 1151848890506, \"total_volume\": 34432896570} ";

    @Autowired
    CriptoValorService criptoValorService;

    @ApiOperation(value = "Retorna informações em tempo real de todas as criptomoedas disponíveis")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorDTO[].class),
            @ApiResponse(code = 404, message = "No cripto price today")
    })
    @GetMapping(produces = JSON)
    public ResponseEntity<?> getAll(){
        List<CriptoValorDTO> criptoValorList = criptoValorService.getAllCriptoValor();
        if(criptoValorList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            return ResponseEntity.ok(criptoValorList);
        }
    }

    @ApiOperation(value = "Retorna informações em tempo real de uma criptomoeda específica")
    @GetMapping(path = "/{id}", produces = JSON )
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CriptoValorDTO.class)})
    public ResponseEntity<?> getPorId(
            @PathVariable (name = "id")
            @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                value = "id da criptomoeda \n *faz referência a /v1/api-criptomoedas") String idCriptoValor){
        CriptoValorDTO criptoValorDTO = criptoValorService.getCriptoValorPorId(idCriptoValor);
        if(Objects.isNull(criptoValorDTO)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST);
        }
        else{
            return ResponseEntity.ok(criptoValorDTO);
        }
    }
}
