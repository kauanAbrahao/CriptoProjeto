package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;

@Api(tags = {SwaggerConfig.CRIPTO_VALOR})
public interface CriptoValorResource {

    @ApiOperation(value = "Retorna informações em tempo real de todas as criptomoedas disponíveis")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<?> getAll();

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
                                                    value = "data de referência (formato yyyy-MM-dd)") String dataRef);



    @ApiOperation(value = "Retorna informações em tempo real de uma criptomoeda específica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Id Not Found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getPorId(@PathVariable(name = "id")
                               @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                                       value = "id da criptomoeda \n *faz referência a /v1/api-criptomoedas") String idCriptoValor);

    @ApiOperation(value = "Retorna informações em tempo real de criptmoedas com market_cap_rank acima do informado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Id Not Found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getAcimaRank(@RequestParam(name = "mktRank")
                               @ApiParam(name = "mkt_cap_rank", example = "2", type = "Integer", required = true,
                                       value = "market cap rank da criptomoeda \n *faz referência a /v1/api-criptomoedas") Integer mktRank);


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
              String dataRef);

    @ApiOperation(value = "Retorna informações históricas para range de data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptoValorHistDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Invalid date(s)"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")})
    ResponseEntity<?> getRangeDate(
            @ApiParam(name = "from", example = "2021-11-01", type = "Date", required = true,
                    value = "data inicial (formato yyyy-MM-dd)") String dtInicial,
            @ApiParam(name = "to", example = "2021-11-03", type = "Date", required = true,
                    value = "data final (formato yyyy-MM-dd)")
                    String dtFim);

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
                    String dtInicial,
            @ApiParam(name = "to", example = "2021-11-03", type = "Date", required = true,
                    value = "data final (formato yyyy-MM-dd)")
                    String dtFim);


}
