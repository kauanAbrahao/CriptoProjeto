package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CriptomoedaDAOImpl extends AbstractDAO {

    public String adicionaCriptomoedas(Criptomoeda criptomoeda){
        String sql = getSql("insertMoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Nome_Cripto", criptomoeda.getName());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        try{
            namedParameterJdbcTemplate.update(sql, params);
            return "deubom";
        } catch (Exception e){
            e.printStackTrace();
            return "deuruim";
        }

    }
}
