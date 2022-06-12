package com.cripto.repository.rowmapper;

import com.cripto.entity.CriptoValor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class CriptoValorRowMapper implements RowMapper<CriptoValor> {


    @Override
    public CriptoValor mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoValor criptoValor = new CriptoValor();
        criptoValor.setId(resultSet.getString("ID_Cripto"));
        criptoValor.setCurrentPrice(resultSet.getBigDecimal("CRT_Price"));
        criptoValor.setMktCap(resultSet.getLong("MKT_Cap"));
        criptoValor.setTotalVolume(resultSet.getBigDecimal("Total_Volume"));
        criptoValor.setDthrInclusao(resultSet.getObject("DataHR_Inc", LocalDateTime.class));
        return criptoValor;
    }
}
