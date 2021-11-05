package com.example.CriptoProjeto.business.endpoint.resource;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.dto.CriptomoedaDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = {SwaggerConfig.CRIPTO_EXTREMOS})
public interface CriptoExtremosResource {

    @ApiOperation(value = "Retorna menor e maior valor para todas as criptomoedas em determinada data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoExtremo[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<?> getAll( @ApiParam(name = "data", example = "2021-11-01", type = "Date", required = true,
            value = "data de referênca (formato yyyy-MM-dd)") String dataRef);

}
