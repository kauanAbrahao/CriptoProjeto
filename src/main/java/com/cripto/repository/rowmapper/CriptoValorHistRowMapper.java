package com.cripto.repository.rowmapper;

import com.cripto.entity.CriptoValorHist;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class CriptoValorHistRowMapper implements RowMapper<CriptoValorHist> {


    @Override
    public CriptoValorHist mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoValorHist criptoValorHist = new CriptoValorHist();
        criptoValorHist.setId(resultSet.getString("ID_Cripto"));
        criptoValorHist.setOpen_price(resultSet.getBigDecimal("Open_Price"));
        criptoValorHist.setAvg_price(resultSet.getBigDecimal("Avg_Price"));
        criptoValorHist.setClose_price(resultSet.getBigDecimal("Close_Price"));
        criptoValorHist.setOpen_mkt_cap(resultSet.getBigDecimal("Open_Mkt_Cap"));
        criptoValorHist.setAvg_mkt_cap(new BigDecimal(resultSet.getInt("Avg_Mkt_cap")));
        criptoValorHist.setClose_mkt_cap(resultSet.getBigDecimal("Close_Mkt_Cap"));
        criptoValorHist.setTotal_volume(resultSet.getBigDecimal("Total_Volume"));
        criptoValorHist.setHigh_price(resultSet.getObject("High", BigDecimal.class));
        criptoValorHist.setLow_price(resultSet.getObject("Low", BigDecimal.class));
        criptoValorHist.setReference_date(resultSet.getObject("Datahr_Inc", LocalDate.class));
        return criptoValorHist;
    }
}
