package com.example.CriptoProjeto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@SpringBootTest
public abstract class AbstractDAOTest {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
