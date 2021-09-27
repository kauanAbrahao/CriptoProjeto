package com.example.CriptoProjeto.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;


@Component
public class MoedaDAOImpl extends AbstractDAO {


    protected MoedaDAOImpl() {
        super(MoedaDAOImpl.class);
    }

    public String adicionaMoeda(){
        SimpleJdbcInsert insert = new SimpleJdbcInsert(mysqlDataSource()).withTableName("tab_cripto");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", "BTC");
        params.addValue("Nome_Cripto", "Bitcoin");
        params.addValue("MKT_Cap_Rank", 200);


        try {
            insert.execute(params);
            return "moeda adicionada";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro no processo";
        }

    }

    public String removeMoedas(){
        String sql = getSql("removeMoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idCripto", "TST");
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return "moeda excluida";
        } catch ( Exception e){
            return "deu merda";
        }

    }
}
