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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Api(tags = {SwaggerConfig.CRIPTOMOEDAS})
@RequestMapping("v1/api-criptomoedas")
public class CriptomoedaController {

    private static final String JSON = "application/json";
    final static String NOT_FOUND_BODY = " {\"code\": 404, \"message\": \"Not found\"} ";

    @Autowired
    CriptomoedaService criptomoedaService;


    @ApiOperation(value = "Retorna lista de todas as criptomoedas suportadas na API", position = 0)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CriptomoedaDTO[].class)})
    @GetMapping(produces = JSON)
    public ResponseEntity<?> getAll(){

        List<CriptomoedaDTO> criptomoedaDTOList = criptomoedaService.getAll();
        if (criptomoedaDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_BODY);
        }
        else{
            return ResponseEntity.ok(criptomoedaDTOList);
        }
    }


}
