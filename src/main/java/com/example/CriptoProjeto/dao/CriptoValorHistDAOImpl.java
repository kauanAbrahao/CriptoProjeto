package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.dao.rowmapper.CriptoValorHistRowMapper;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CriptoValorHistDAOImpl extends AbstractDAO {

    @Autowired
    CriptoValorHistRowMapper criptoValorHistRowMapper;

    public List<CriptoValorHistDTO> getAllDate(LocalDate dtRef) {
        String sql = getSql("getAllDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dtRef.toString());
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<CriptoValorHistDTO> getIdDate(String idCripto, LocalDate dtRef) {
        String sql = getSql("getIdDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dtRef.toString());
        params.addValue("idCripto", idCripto);
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<CriptoValorHistDTO> getRangeDate(LocalDate dtInicial, LocalDate dtFim) {
        String sql = getSql("getRangeDate");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtInicial", dtInicial.toString());
        params.addValue("dtFim", dtFim.toString());
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<CriptoValorHistDTO> getRangeDateId(LocalDate dtInicial, LocalDate dtFim, String idCripto) {
        String sql = getSql("getRangeDateId");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtInicial", dtInicial.toString());
        params.addValue("dtFim", dtFim.toString());
        params.addValue("idCripto", idCripto);
        try {
            return namedParameterJdbcTemplate.query(sql, params, criptoValorHistRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
