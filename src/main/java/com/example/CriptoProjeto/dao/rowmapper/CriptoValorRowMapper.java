package com.example.CriptoProjeto.dao.rowmapper;

import com.example.CriptoProjeto.entity.CriptoModelo;
import com.example.CriptoProjeto.entity.CriptoValor;
import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CriptoValorRowMapper implements RowMapper<CriptoValor> {


    @Override
    public CriptoValor mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoValor criptoValor = new CriptoValor();
        criptoValor.setId(resultSet.getString("ID_Cripto"));
        criptoValor.setCurrentPrice(resultSet.getBigDecimal("CRT_Price"));
        criptoValor.setMktCap(resultSet.getLong("MKT_Cap"));
        criptoValor.setTotalVolume(resultSet.getBigDecimal("Total_Volume"));
        criptoValor.setDthrInclusao((resultSet.getDate("DataHR_Inc")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        return criptoValor;
    }
}
