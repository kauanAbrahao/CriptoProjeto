package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Component
public class MoedaDAOImpl extends AbstractDAO {


    public String adicionaMoeda(Criptomoeda criptomoeda){
        String sql = getSql("insertMoeda");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Nome_Cripto", criptomoeda.getNome());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMrkCapt());
        try{
            namedParameterJdbcTemplate.update(sql, params);
            return "deubom";
        } catch (Exception e){
            e.printStackTrace();
            return "deuruim";
        }

    }

    public String removerMoeda(){
       return ("Você está no removerMoeda da Classe MoedaDAOImpl");
    }
}
