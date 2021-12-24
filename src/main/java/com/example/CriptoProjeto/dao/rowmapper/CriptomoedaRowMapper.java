package com.example.CriptoProjeto.dao.rowmapper;

import com.cripto.entity.Criptomoeda;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CriptomoedaRowMapper implements RowMapper<Criptomoeda> {


    @Override
    public Criptomoeda mapRow(ResultSet resultSet, int i) throws SQLException {
        Criptomoeda criptomoeda = new Criptomoeda();
        criptomoeda.setId(resultSet.getString("ID_Cripto"));
        criptomoeda.setName(resultSet.getString("Nome_Cripto"));
        criptomoeda.setMktCapRank(resultSet.getInt("MKT_Cap_Rank"));
        criptomoeda.setSymbol((resultSet.getString("Symbol")));
        return criptomoeda;
    }
}
