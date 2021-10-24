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
            case "buscarMoedas":
                return "SELECT * FROM tab_cripto";
            case "buscaMoedaPorId":
                return "SELECT * FROM tab_cripto WHERE ID_Cripto = :idCripto";
            case "insertMoedas":
                return "INSERT INTO tab_cripto VALUES (:ID_Cripto, :Nome_Cripto, :MKT_Cap_Rank, :Symbol)";
            case "insertCriptoValor":
                return "INSERT INTO tab_valor VALUES (:ID_Cripto, :CRT_Price, :MKT_Cap, :Total_Volume, CURRENT_TIMESTAMP())";
            case "insertCriptoExtremo":
                return "INSERT INTO tab_extremos VALUES (:ID_Cripto, :High_low, :Valor, CURRENT_TIMESTAMP()";
        }

        return null;
    }

}
