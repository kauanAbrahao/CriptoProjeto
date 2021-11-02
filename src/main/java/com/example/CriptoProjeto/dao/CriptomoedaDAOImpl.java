package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.dao.rowmapper.CriptomoedaRowMapper;
import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.CriptoModelo;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.enums.EnumHighLow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Component
public class CriptomoedaDAOImpl extends AbstractDAO {

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

    public void adicionarCriptoValor(CriptoValor criptoValor){
        String sql = getSql("insertCriptoValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoValor.getId());
        params.addValue("CRT_Price", criptoValor.getCurrentPrice());
        params.addValue("MKT_Cap", criptoValor.getMktCap());
        params.addValue("Total_Volume", criptoValor.getTotalVolume());
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adicionarCriptoExtremo(CriptoExtremo criptoExtremo, boolean isHigh){
        String sql = getSql("insertCriptoExtremo");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoExtremo.getId());
        params.addValue("High_low", isHigh ? EnumHighLow.HIGH.getValue() : EnumHighLow.LOW.getValue());
        params.addValue("Valor", isHigh ? criptoExtremo.getHighValueDay() : criptoExtremo.getLowValueDay());
        try{
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public List<Criptomoeda> getAll() {
        String sql = getSql("buscarCriptomoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<Criptomoeda> c = null;
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
