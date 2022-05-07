package com.cripto.repository;

import com.cripto.entity.CriptoValorHist;
import com.cripto.repository.rowmapper.CriptoValorHistRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CriptoValorHistRepository extends AbstractRespository{

    @Autowired
    CriptoValorHistRowMapper criptoValorHistRowMapper;

    public List<CriptoValorHist> getAllDate(LocalDate dtRef) {
        String sql = getSql("getAllDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dtRef.toString());
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            log.error(e.getMessage(), e.getCause());
            return new ArrayList<>();
        }
    }

    public List<CriptoValorHist> getIdDate(String idCripto, LocalDate dtRef) {
        String sql = getSql("getIdDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dtRef.toString());
        params.addValue("idCripto", idCripto);
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            log.error(e.getMessage(), e.getCause());
            return new ArrayList<>();
        }
    }

    public List<CriptoValorHist> getRangeDate(LocalDate dtInicial, LocalDate dtFim) {
        String sql = getSql("getRangeDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtInicial", dtInicial.toString());
        params.addValue("dtFim", dtFim.toString());
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            log.error(e.getMessage(), e.getCause());
            return new ArrayList<>();
        }
    }

    public List<CriptoValorHist> getRangeDateId(LocalDate dtInicial, LocalDate dtFim, String idCripto) {
        String sql = getSql("getRangeDateId");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtInicial", dtInicial.toString());
        params.addValue("dtFim", dtFim.toString());
        params.addValue("idCripto", idCripto);
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            log.error(e.getMessage(), e.getCause());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void movimentarParaCriptoValorHist () {
        String sql = getSql("toValorHist");
        MapSqlParameterSource params = new MapSqlParameterSource();
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
