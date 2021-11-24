package com.example.CriptoProjeto.dao.rowmapper;

import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.dto.CriptoValorHistDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CriptoValorHistRowMapper implements RowMapper<CriptoValorHistDTO> {


    @Override
    public CriptoValorHistDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoValorHistDTO criptoValorHistDTO = new CriptoValorHistDTO();
        criptoValorHistDTO.setId(resultSet.getString("ID_Cripto"));
        criptoValorHistDTO.setOpen_price(resultSet.getBigDecimal("Open_Price"));
        criptoValorHistDTO.setAvg_price(resultSet.getBigDecimal("Avg_Price"));
        criptoValorHistDTO.setClose_price(resultSet.getBigDecimal("Close_Price"));
        criptoValorHistDTO.setOpen_mkt_cap(resultSet.getLong("Open_Mkt_Cap"));
        criptoValorHistDTO.setAvg_mkt_cap(new BigDecimal(resultSet.getInt("Avg_Mkt_cap")));
        criptoValorHistDTO.setClose_mkt_cap(resultSet.getLong("Close_Mkt_Cap"));
        criptoValorHistDTO.setTotal_volume(resultSet.getObject("Total_Volume", Long.class));
        criptoValorHistDTO.setHigh_price(resultSet.getObject("High", BigDecimal.class));
        criptoValorHistDTO.setLow_price(resultSet.getObject("Low", BigDecimal.class));
        criptoValorHistDTO.setReference_date(resultSet.getObject("Datahr_Inc", LocalDate.class));
        return criptoValorHistDTO;
    }
}
