package com.example.CriptoProjeto.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan
public abstract class AbstractDAO {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3308/modocripto");
//        dataSource.setUsername("criptoproj");
//        dataSource.setPassword("cr1pP@ss21");
//
//        return dataSource;
//    }

    public String getSql(String query){
        switch (query){
            case "buscarCriptomoedas":
                return "SELECT * FROM tab_cripto";
            case "buscaMoedaPorId":
                return "SELECT * FROM tab_cripto WHERE ID_Cripto = :idCripto";
            case "insertMoedas":
                return "INSERT INTO tab_cripto VALUES (:ID_Cripto, :Nome_Cripto, :MKT_Cap_Rank, :Symbol)";
            case "insertCriptoValor":
                return "INSERT INTO tab_valor VALUES (:ID_Cripto, :CRT_Price, :MKT_Cap, :Total_Volume, CURRENT_TIMESTAMP())";
            case "insertCriptoExtremo":
                return "INSERT INTO tab_extremos VALUES (:ID_Cripto, :High_low, :Valor, CURRENT_TIMESTAMP())";
            case "getAllCriptoValor":
                return "SELECT * FROM tab_valor";
            case "getPorIdCriptoValor":
                return "SELECT * FROM tab_valor WHERE ID_Cripto = :idCripto ORDER BY DataHR_Inc desc LIMIT 1; ";
            case "insertValorHist":
                return "call to_valor_hist();";
            case "deleteTabValor":
                return "DELETE FROM Tab_Valor WHERE DATAHR_INC < DATE_sub(curdate(), interval 1 day);";
        }

        return null;
    }

}
