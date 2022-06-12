package com.cripto.repository.rowmapper;

import com.cripto.entity.dto.CriptoExtremoDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class CriptoExtremoRowMapper implements RowMapper<CriptoExtremoDTO> {

    @Override
    public CriptoExtremoDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoExtremoDTO criptoExtremo = new CriptoExtremoDTO();
        criptoExtremo.setId(resultSet.getString("ID_Cripto"));
        criptoExtremo.setHigh_value_day(resultSet.getDouble("High"));
        criptoExtremo.setLow_value_day(resultSet.getDouble("Low"));
        criptoExtremo.setReference_date(resultSet.getObject("DataHR_Inc", LocalDate.class));
        return criptoExtremo;
    }
}
