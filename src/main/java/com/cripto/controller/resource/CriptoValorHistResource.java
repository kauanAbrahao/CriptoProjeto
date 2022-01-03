package com.cripto.controller.resource;

import com.cripto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Api(tags = {SwaggerConfig.CRIPTO_VALOR_HIST})
public interface CriptoValorHistResource {


    @ApiOperation(value = "Retorna informações históricas para determinada data e criptomoeda")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorHistDTO.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Id Not Found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getDateId(
            @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                    value = "id da criptomoeda \n *faz referência a /v1/api-criptomoedas") String idCripto,
            @ApiParam(name = "date", example = "2021-11-01", type = "Date", required = true,
                    value = "data de referência (formato yyyy-MM-dd)")
                    LocalDate dataRef);

    @ApiOperation(value = "Retorna informações históricas para range de data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorHistDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Invalid date(s)"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getRangeDate(
            @ApiParam(name = "from", example = "2021-11-01", type = "Date", required = true,
                    value = "data inicial (formato yyyy-MM-dd)") LocalDate dtInicial,
            @ApiParam(name = "to", example = "2021-11-03", type = "Date", required = true,
                    value = "data final (formato yyyy-MM-dd)") LocalDate dtFim);

    @ApiOperation(value = "Retorna informações históricas de uma criptomoeda específica em um range de data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorHistDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Invalid date(s)"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getRangeDateId(
            @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                    value = "id da criptomoeda \n *faz referência a /v1/api-criptomoedas")
                    String idCripto,
            @ApiParam(name = "from", example = "2021-11-01", type = "Date", required = true,
                    value = "data inicial (formato yyyy-MM-dd)")
                    LocalDate dtInicial,
            @ApiParam(name = "to", example = "2021-11-03", type = "Date", required = true,
                    value = "data final (formato yyyy-MM-dd)")
                    LocalDate dtFim);

    @ApiOperation(value = "Retorna informações históricas de todas as criptomoedas para determinada data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorHistDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request - Invalid date"),
            @ApiResponse(code = 404, message = "Not found - Invalid date"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })

    public ResponseEntity<?> getAllDate(@PathVariable(name = "date")
                                        @ApiParam(name = "date", example = "2021-11-01", type = "Date", required = true,
                                                value = "data de referência (formato yyyy-MM-dd)") LocalDate dataRef);
}
