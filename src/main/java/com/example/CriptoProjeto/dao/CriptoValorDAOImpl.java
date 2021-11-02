package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.dao.rowmapper.CriptoValorRowMapper;
import com.example.CriptoProjeto.entity.CriptoValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CriptoValorDAOImpl extends AbstractDAO {

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
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<CriptoValor> getCriptoValorListPorRank(Integer mktRank) {
        String sql = getSql("getCriptoValorListPorRank");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mktRank", mktRank);
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
