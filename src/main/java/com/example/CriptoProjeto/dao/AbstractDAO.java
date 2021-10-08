package com.example.CriptoProjeto.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

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
            case "insertMoeda":
                return "INSERT INTO tab_cripto VALUES (:ID_Cripto, :Nome_Cripto, :MKT_Cap_Rank)";
        }

        return null;
    }

}
