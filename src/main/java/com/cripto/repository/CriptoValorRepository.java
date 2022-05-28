package com.cripto.repository;

import com.cripto.repository.rowmapper.CriptoValorRowMapper;
import com.cripto.entity.CriptoValor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CriptoValorRepository extends AbstractRespository{

    @Autowired
    CriptoValorRowMapper criptoValorRowMapper;


    public List<CriptoValor> getAll(){
        String sql = getSql("getAllCriptoValor");
        try{
            return namedParameterJdbcTemplate.query(sql, criptoValorRowMapper);
        } catch (Exception e){
            log.error(e.getMessage(), e.getCause());
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
            log.error(e.getMessage(), e.getCause());
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
            log.error(e.getMessage(), e.getCause());
            return null;
        }
    }

    public void adicionarCriptoValor(CriptoValor criptoValor) {
        String sql = getSql("insertCriptoValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoValor.getId());
        params.addValue("CRT_Price", criptoValor.getCurrentPrice());
        params.addValue("MKT_Cap", criptoValor.getMktCap());
        params.addValue("Total_Volume", criptoValor.getTotalVolume());
        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e) {
            log.error("Erro no insertCriptoValor " + e.getMessage(), e.getCause());
        }
    }
}
