package com.cripto.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractRespository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String getSql(String query){

        switch (query){
            case "buscarCriptomoedas":
                return "SELECT * FROM tab_cripto";

            case "insertCriptomoedas":
                return "INSERT INTO tab_cripto VALUES (:ID_Cripto, :Nome_Cripto, :MKT_Cap_Rank, :Symbol)";

            case "insertCriptoValor":
                return "exec proc_insertTabValor @cripto_id = :ID_Cripto, @CRT_Price = :CRT_Price, @MKT_Cap = :MKT_Cap, @Total_Volume = :Total_Volume;";

            case "insertCriptoExtremo":
//                return "INSERT INTO tab_extremos VALUES (:ID_Cripto, :High, :Low, CURRENT_TIMESTAMP())";
//                return "insert into TAB_EXTREMOS (id_cripto, high, low, datahr_inc) " +
//                        "select ID_Cripto, max(CRT_Price),min(CRT_Price),cast(DataHR_Inc as date)  " +
//                        "from tab_valor " +
//                        "where cast(DataHR_Inc as date) = cast(current_timestamp as date) " +
//                        "group by id_cripto,cast(DataHR_Inc as date) ;";
                return "exec proc_insertTabExtremos @cripto_id = :ID_Cripto, @High = :High, @Low = :Low;";

            case "getAllCriptoValor":
                return "WITH top_row AS (\n" +
                        "  SELECT *, ROW_NUMBER() OVER (PARTITION BY tv.ID_Cripto ORDER BY tv.DataHR_Inc DESC) AS rn\n" +
                        "  FROM tab_valor tv)\n" +
                        " SELECT * from top_row WHERE rn=1;";

            case "getPorIdCriptoValor":
                return "SELECT TOP 1 * FROM tab_valor WHERE ID_Cripto = :idCripto ORDER BY DataHR_Inc desc ; ";

            case "toValorHist":
//                return "call to_valor_hist();";
                return"exec to_valor_hist;";

            case "deleteTabValor":
                return "DELETE FROM Tab_Valor WHERE DATAHRC_INC < cast(current_timestamp-1 as date);";

            case "getCriptoValorListPorRank":
                return "WITH top_row AS (\n" +
                        "  SELECT tv.*, ROW_NUMBER() OVER (PARTITION BY tv.ID_Cripto ORDER BY tv.DataHR_Inc DESC) AS rn\n" +
                        "  FROM tab_valor AS tv\n" +
                        ")\n" +
                        "SELECT * FROM top_row\n" +
                        "    JOIN tab_cripto tc ON (top_row.ID_Cripto = tc.ID_Cripto)\n" +
                        "  WHERE tc.MKT_Cap_Rank <= :mktRank and rn = 1;";

            case "getAllDate":
//                return "SELECT tvh.*, te.High, te.Low from tab_valor_hist tvh \n "+
//                        "JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto) \n"+
//                    " WHERE DATE (tvh.Datahr_Inc) = :dtRef and DATE(te.DataHR_Inc) = :dtRef;";
                 return "SELECT DISTINCT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
                         "                        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto and CAST (te.DataHR_Inc AS DATE) =  CAST (tvh.DataHR_Inc AS DATE))\n" +
                         "                 WHERE CAST(tvh.Datahr_Inc AS DATE) = :dtRef and CAST(te.DataHR_Inc AS DATE) = :dtRef;";

            case "getIdDate":
//                return "SELECT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
//                        "        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto)\n" +
//                        " WHERE DATE (tvh.Datahr_Inc) = :dtRef\n" +
//                        "   and DATE(te.DataHR_Inc) = :dtRef\n" +
//                        "   and tvh.ID_Cripto = :idCripto;";
                    return "SELECT DISTINCT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
                            "        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto and CAST (te.DataHR_Inc AS DATE) =  CAST (tvh.DataHR_Inc AS DATE))\n" +
                            " WHERE CAST (tvh.Datahr_Inc AS DATE) = :dtRef\n" +
                            "   and CAST (te.DataHR_Inc AS DATE) = :dtRef\n" +
                            "   and tvh.ID_Cripto = :idCripto;";

            case "getRangeDate":
//                return "SELECT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
//                        "        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto)\n" +
//                        " WHERE DATE (tvh.Datahr_Inc) BETWEEN :dtInicial and :dtFim;";
                  return " SELECT DISTINCT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
                          "                        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto and CAST (te.DataHR_Inc AS DATE) =  CAST (tvh.DataHR_Inc AS DATE))\n" +
                          "                                     WHERE CAST (tvh.Datahr_Inc AS DATE) BETWEEN :dtInicial and :dtFim;";

            case "getRangeDateId":
                return "SELECT DISTINCT tvh.*, te.High, te.Low from tab_valor_hist tvh\n" +
                        "        JOIN tab_extremos te ON (tvh.ID_Cripto = te.ID_Cripto and CAST (te.DataHR_Inc AS DATE) = CAST (tvh.DataHR_Inc AS DATE))\n" +
                        " WHERE CAST (tvh.Datahr_Inc AS DATE) BETWEEN :dtInicial and :dtFim\n" +
                        " and tvh.ID_Cripto = :idCripto;";

            case "updateCriptomoeda":
                return "UPDATE Tab_Cripto SET MKT_Cap_Rank = :MKT_Cap_Rank WHERE ID_Cripto = :ID_Cripto ";

            case "insertDadosHist":
                return "INSERT INTO tab_valor_hist (ID_Cripto, Close_Price, Total_Volume, Close_Mkt_Cap, DataHR_Inc) VALUES (:ID_Cripto, :CRT_Price, :Total_Volume, :MKT_Cap, :DataHR_Inc )";

            case "getAllCriptoExtremo":
//                return "SELECT * from tab_extremos where DATE(DataHR_Inc) = :dtRef;";
                  return "SELECT * from tab_extremos where CAST(DataHr_Inc as DATE) = :dtRef;";

            case "buscarCriptomoedaPorId":
                return "SELECT * FROM TAB_CRIPTO WHERE ID_Cripto = :idCriptomoeda;";

            case "getCriptoExtremoById":
                return "SELECT * FROM TAB_EXTREMOS WHERE ID_Cripto = :ID_Cripto and CAST(DataHr_Inc as DATE) = :dtRef;";
        }

        return null;
    }

}
