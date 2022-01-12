package com.cripto.repository;

import com.cripto.entity.CriptoExtremo;
import com.cripto.entity.CriptoValor;
import com.cripto.entity.Criptomoeda;
import com.cripto.repository.rowmapper.CriptomoedaRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Slf4j
public class CriptomoedaRepository extends AbstractRespository {

    public void adicionaCriptomoedas(Criptomoeda criptomoeda){
        String sql = getSql("insertCriptomoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Symbol", criptomoeda.getSymbol());
        params.addValue("Nome_Cripto", criptomoeda.getName());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void atualizarCriptomoedas(Criptomoeda criptomoeda){
        String sql = getSql("updateCriptomoeda");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Symbol", criptomoeda.getSymbol());
        params.addValue("Nome_Cripto", criptomoeda.getName());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
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

    //TODO - REFATORAR ESSE MÉTODO HORRÍVEL
    /*
    public void adicionarCriptoValorHist(CriptoValorHistParser criptoValor, String DataHR) {
        String sql = getSql("insertDadosHist");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoValor.getId());
        params.addValue("CRT_Price", Double.valueOf(criptoValor.getMarketData().getCurrentPrice().getBrl()));
        params.addValue("MKT_Cap", Double.valueOf(criptoValor.getMarketData().getMarketCap().getBrl()));
        params.addValue("Total_Volume", Double.valueOf(criptoValor.getMarketData().getTotalVolume().getBrl()));
        params.addValue("DataHR_Inc", DataHR);
        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

    public void adicionarCriptoExtremo(CriptoExtremo criptoExtremo){
        String sql = getSql("insertCriptoExtremo");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoExtremo.getId());
        params.addValue("High", criptoExtremo.getHighValueDay());
        params.addValue("Low",  criptoExtremo.getLowValueDay());
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            log.error("Erro na atualização TAB_EXTREMOS. " + e.getMessage(), e.getCause());
        }

    }


    public List<com.cripto.entity.Criptomoeda> buscarCriptomoedas() {
        String sql = getSql("buscarCriptomoedas");
        List<com.cripto.entity.Criptomoeda> c = null;
        try{
            c = (namedParameterJdbcTemplate.query(sql, new CriptomoedaRowMapper()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public void adicionarCriptoValorHistorico () {
        String sql = getSql("insertValorHist");
        MapSqlParameterSource params = new MapSqlParameterSource();
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarCriptoValor () {
        String sql = getSql("deleteTabValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
