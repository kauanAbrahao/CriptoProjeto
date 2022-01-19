package com.cripto.controller.resource;

import com.cripto.SwaggerConfig;
import com.cripto.entity.CriptoExtremo;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Api(tags = {SwaggerConfig.CRIPTO_EXTREMOS})
public interface CriptoExtremosResource {

    @ApiOperation(value = "Retorna menor e maior valor para todas as criptomoedas em determinada data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoExtremo[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal error"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<?> getAll( @ApiParam(name = "data", example = "2021-11-01", type = "Date", required = true,
            value = "data de referênca (formato yyyy-MM-dd)") LocalDate dataRef);

    @ApiOperation(value = "Retorna menor e maior valor para todas as criptomoedas em determinada data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoExtremo[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<?> getById(@ApiParam(name = "data", example = "2021-11-01", type = "Date", required = true,
            value = "data de referênca (formato yyyy-MM-dd)") LocalDate dataRef,
                                     @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                                     value = "id da criptomoeda \n *faz referência a /v1/ap-cripto/list") String id);

}
