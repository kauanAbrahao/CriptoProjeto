package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.entity.dto.CriptomoedaDTO;
import com.example.CriptoProjeto.service.CriptomoedaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("v1/api-criptomoedas")
public class CriptomoedaController implements CriptomoedaResource {


    @Autowired
    CriptomoedaService criptomoedaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        return criptomoedaService.getAll();
    }


}
