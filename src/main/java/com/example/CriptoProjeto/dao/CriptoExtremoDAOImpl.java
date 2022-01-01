package com.example.CriptoProjeto.dao;

import com.cripto.repository.rowmapper.CriptoExtremoRowMapper;
import com.example.CriptoProjeto.entity.dto.CriptoExtremoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriptoExtremoDAOImpl extends AbstractDAO {

    @Autowired
    CriptoExtremoRowMapper criptoExtremoRowMapper;

    public List<CriptoExtremoDTO> getAll(String dataRef) {
        String sql = getSql("getAllCriptoExtremo");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dataRef);
        try{
            return namedParameterJdbcTemplate.query(sql, params, criptoExtremoRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
