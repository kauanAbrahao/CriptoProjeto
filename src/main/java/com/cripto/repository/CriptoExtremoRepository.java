package com.cripto.repository;

import com.cripto.entity.dto.CriptoExtremoDTO;
import com.cripto.repository.rowmapper.CriptoExtremoRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CriptoExtremoRepository extends AbstractRespository {

    @Autowired
    CriptoExtremoRowMapper criptoExtremoRowMapper;


    public List<CriptoExtremoDTO> getAllCriptoExtremo(LocalDate dataRef) {
        String sql = getSql("getAllCriptoExtremo");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dtRef", dataRef.toString());
        try{
            return namedParameterJdbcTemplate.query(sql, params, criptoExtremoRowMapper);
        } catch (Exception e){
            log.error("Erro no INSERT TAB_EXTREMOS ==> ", e.getCause());
            return new ArrayList<>();
        }
    }

}
