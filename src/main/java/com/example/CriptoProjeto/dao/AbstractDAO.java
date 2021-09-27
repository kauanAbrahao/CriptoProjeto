package com.example.CriptoProjeto.dao;

import com.opengamma.elsql.ElSql;
import com.opengamma.elsql.ElSqlConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public abstract class AbstractDAO {

     ElSql elSqlBundle;
     NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected AbstractDAO(Class<?> classe) {
        try{
            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(mysqlDataSource());
            elSqlBundle = ElSql.of(ElSqlConfig.MYSQL, classe);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3308/modocripto");
        dataSource.setUsername("criptoproj");
        dataSource.setPassword("cr1pP@ss21");

        return dataSource;
    }

    protected String getSql(String sqlQuery){
        String sql = elSqlBundle.getSql(sqlQuery);
        return sql;
    }

}
