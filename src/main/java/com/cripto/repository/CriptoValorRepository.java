package com.cripto.repository;

import com.cripto.repository.rowmapper.CriptoValorRowMapper;
import com.cripto.entity.CriptoValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class CriptoValorRepository extends AbstractRespository{

    @Autowired
    CriptoValorRowMapper criptoValorRowMapper;


    public List<CriptoValor> getAll(){
        String sql = getSql("getAllCriptoValor");
        try{
            return namedParameterJdbcTemplate.query(sql, criptoValorRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public CriptoValor getPorId(String idCriptoValor) {
        String sql = getSql("getPorIdCriptoValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idCripto", idCriptoValor);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, criptoValorRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
