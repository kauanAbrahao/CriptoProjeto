package com.cripto.repository;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.repository.rowmapper.CriptomoedaRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CriptomoedaRepository extends AbstractRespository {

    public void adicionaCriptomoedas(Criptomoeda criptomoeda) throws Exception {
        String sql = getSql("insertCriptomoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Symbol", criptomoeda.getSymbol());
        params.addValue("Nome_Cripto", criptomoeda.getName());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void atualizarMktRankCrpiptomoedas(Criptomoeda criptomoeda) throws Exception {
        String sql = getSql("updateCriptomoeda");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        namedParameterJdbcTemplate.update(sql, params);
    }


    public List<Criptomoeda> buscarCriptomoedas() {
        String sql = getSql("buscarCriptomoedas");
        return namedParameterJdbcTemplate.query(sql, new CriptomoedaRowMapper());
    }


    public Criptomoeda buscarCriptomoedaPorId(String idCriptomoeda) {
        String sql = getSql("buscarCriptomoedaPorId");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idCriptomoeda", idCriptomoeda);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new CriptomoedaRowMapper());
    }
}
