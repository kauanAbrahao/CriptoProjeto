package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.yaml.snakeyaml.util.EnumUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
@EnableScheduling
public class CriptomoedaBusiness {

    @Autowired
    GsonReceiver gsonReceiver;
    @Autowired
    CriptomoedaDAOImpl moedaDao;

    final String tempoReq = "6000";

//    @Scheduled(fixedDelayString = tempoReq)
//    public void buscaJsonCriptoValorScheduler() throws IOException {
//        String json = gsonReceiver.getCriptoJsonMarkets();
//         List<CriptoValor> criptovalorList = GsonParser.jsonToObjectList(json, CriptoValor[].class);
//         for (CriptoValor criptovalor : criptovalorList) {
//             if (isInEnum(criptovalor.getId(), EnumCripto.class) == true){
//                 moedaDao.adicionarCriptoValor(criptovalor);
//             }
//         }
//    }

    @Scheduled(cron = "0 50 20 * * ?")
    public void buscaJsonCriptoExtremo() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoExtremo> criptoextremoList = GsonParser.jsonToObjectList(json, CriptoExtremo[].class);
        for (CriptoExtremo criptoextremo : criptoextremoList) {
            if (isInEnum(criptoextremo.getId(), EnumCripto.class) == true){
               moedaDao.adicionarCriptoExtremo(criptoextremo, false);
               moedaDao.adicionarCriptoExtremo(criptoextremo, true);
               // System.out.println(criptoextremo.getId() + criptoextremo.getHighValueDay());
            }
        }
    }

      //  @Scheduled(fixedDelayString = tempoReq)
    public void buscaJsonCriptomoedaScheduler() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
         List<Criptomoeda> criptovalorList = GsonParser.jsonToObjectList(json, Criptomoeda[].class);
         for (Criptomoeda m : criptovalorList) {
                 moedaDao.adicionaCriptomoedas(m);
         }
    }
    //@Scheduled(fixedDelayString = tempoReq)
    public void getEnumValues () throws IOException{
        List <Criptomoeda> criptomoedaList = moedaDao.getCriptoInfo();
        for (Criptomoeda c : criptomoedaList){
            System.out.println(c.getId().toUpperCase(Locale.ROOT)+"(\""+c.getId()+"\",\"" +c.getSymbol()+"\",\""+c.getName()+"\"),");
        }
    }

    public boolean isInEnum(String value, Class <EnumCripto> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.getId().equals(value));
    }


}
