package com.example.CriptoProjeto.business.endpoint.resource;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptomoedaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(tags = {SwaggerConfig.CRIPTOMOEDAS})
public interface CriptomoedaResource {



    @ApiOperation(value = "Retorna lista de todas as criptomoedas suportadas na API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptomoedaDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<?> getAll();
}
