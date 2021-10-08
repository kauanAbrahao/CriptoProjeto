package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.dao.rowmapper.CriptomoedaRowMapper;
import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MoedaDAOImpl extends AbstractDAO {

    final CriptomoedaRowMapper criptomoedaRowMapper = new CriptomoedaRowMapper();


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

    public List<Criptomoeda> buscarMoedas() {
        String sql = getSql("buscarMoedas");

        try {
            return  namedParameterJdbcTemplate.query(sql, criptomoedaRowMapper);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
