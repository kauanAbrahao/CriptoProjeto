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
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
@EnableScheduling
public class CriptomoedaBusiness {

    @Autowired
    GsonReceiver gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl moedaDao;

    @Transactional
    /**
     * Requisição feita a cada 2 minutos. Busca dados atuais de cada Criptomoeda
     * @throws IOException
     */
    @Scheduled(fixedDelayString = "${schedule.timeRequest}")
    public void buscaJsonCriptoValorScheduler() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
         List<CriptoValor> criptovalorList = GsonParser.jsonToObjectList(json, CriptoValor[].class);
         for (CriptoValor criptovalor : criptovalorList) {
             if (EnumCripto.isInEnum(criptovalor.getId(), EnumCripto.class)){
                 moedaDao.adicionarCriptoValor(criptovalor);
             }
         }
    }

    /**
     * Requisição feita ao final do dia. Captura o maior e menor valor de cada criptomoeda para o dia de referência
     * @throws IOException
     */
    @Scheduled(cron = "59 59 23 * * ?")
    public void buscaJsonCriptoExtremo() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoExtremo> criptoextremoList = GsonParser.jsonToObjectList(json, CriptoExtremo[].class);
        for (CriptoExtremo criptoextremo : criptoextremoList) {
            if (EnumCripto.isInEnum(criptoextremo.getId(), EnumCripto.class)){
               moedaDao.adicionarCriptoExtremo(criptoextremo, false);
               moedaDao.adicionarCriptoExtremo(criptoextremo, true);
               // System.out.println(criptoextremo.getId() + criptoextremo.getHighValueDay());
            }
        }
    }

    /**
     * Busca lista de Criptomoedas. Não é necessário rodar esse método, uma vez populado o banco.
     * @throws IOException
     */
 /*   @Scheduled(fixedDelayString = "${schedule.timeRequest}")
    public void buscaJsonCriptomoedaScheduler() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
         List<Criptomoeda> criptovalorList = GsonParser.jsonToObjectList(json, Criptomoeda[].class);
         for (Criptomoeda m : criptovalorList) {
                 moedaDao.adicionaCriptomoedas(m);
         }
    }   */
    @Scheduled(cron = "0 0 0 * * ?")
    public void buscaJsonCriptomoedaScheduler() throws IOException {
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<Criptomoeda> criptomoedaList = GsonParser.jsonToObjectList(json, Criptomoeda[].class);
        for (Criptomoeda criptomoeda : criptomoedaList) {
            if (EnumCripto.isInEnum(criptomoeda.getId(), EnumCripto.class)){
                moedaDao.atualizarCriptomoedas(criptomoeda);
            }
        }
    }

    public void getEnumValues () throws IOException{
        List <Criptomoeda> criptomoedaList = moedaDao.getAll();
        for (Criptomoeda c : criptomoedaList){
            System.out.println(c.getId().toUpperCase(Locale.ROOT)+"(\""+c.getId()+"\",\"" +c.getSymbol()+"\",\""+c.getName()+"\"),");
        }
    }


}
