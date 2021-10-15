package com.example.CriptoProjeto.dao.rowmapper;

import com.example.CriptoProjeto.entity.CriptoModelo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CriptomoedaRowMapper implements RowMapper<CriptoModelo> {


    @Override
    public CriptoModelo mapRow(ResultSet resultSet, int i) throws SQLException {
        CriptoModelo criptoModelo = new CriptoModelo();
        criptoModelo.setId(resultSet.getString("ID_Cripto"));
        criptoModelo.setName(resultSet.getString("Nome_Cripto"));
        criptoModelo.setMrkCapt(resultSet.getInt("MKT_Cap_Rank"));
        return criptoModelo;
    }
}
