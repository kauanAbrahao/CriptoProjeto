package com.example.CriptoProjeto.business.endpoint.resource;

import com.example.CriptoProjeto.SwaggerConfig;
import com.cripto.entity.dto.CriptoValorDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

}
