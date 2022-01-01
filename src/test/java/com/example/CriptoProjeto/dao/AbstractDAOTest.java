package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.CriptoProjetoApplication;
import com.cripto.repository.rowmapper.CriptoValorRowMapper;
import com.cripto.entity.CriptoValor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest(classes = CriptoProjetoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CriptoProjetoApplication.class)
public abstract class AbstractDAOTest {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @ExtendWith(SpringExtension.class)
    @SpringBootTest(classes = { TestConfiguration.class })
    public class SampleServiceTest{}

    public CriptoValor buscaCriptoValorTestAux(CriptoValor criptoValor){
        String sql = getSql("buscaCriptoValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptoValor.getId());
        try{
            return namedParameterJdbcTemplate.queryForObject(sql, params, new CriptoValorRowMapper());
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getSql(String query) {
        switch (query) {
            case "buscaCriptoValor":
                return "SELECT * FROM tab_valor WHERE ID_Cripto = :ID_Cripto LIMIT 1";
            case "limpaTabValor":
                return "DELETE FROM tab_valor WHERE 1=1";
        }
        return null;
    }

    public void limpaTabValor(){
        String sql = getSql("limpaTabValor");
        MapSqlParameterSource params = new MapSqlParameterSource();
        namedParameterJdbcTemplate.update(sql, params);
    }

}
