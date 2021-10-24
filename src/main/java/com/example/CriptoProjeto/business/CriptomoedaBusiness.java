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

    @Scheduled(fixedDelayString = tempoReq)
    public void buscaJsonCriptoValorScheduler() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
         List<CriptoValor> criptovalorList = GsonParser.jsonToObjectList(json, CriptoValor[].class);
         for (CriptoValor m : criptovalorList) {
             if (isInEnum(m.getId(), EnumCripto.class) == true){
                 moedaDao.adicionarCriptoValor(m);
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




   // @Scheduled(cron = "0 50 20 * * ?")
    public void buscaJsonCriptoExtremosScheduler() throws IOException {
        GsonReceiver gsonReceiver = new GsonReceiver();
        String json = gsonReceiver.getCriptoJsonMarkets();

        List<CriptoValor> criptomoedaList = GsonParser.jsonToObjectList(json, CriptoValor[].class);
        System.out.println(criptomoedaList.get(0).toString());
    }

    public boolean isInEnum(String value, Class <EnumCripto> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.getId().equals(value));
    }


}
