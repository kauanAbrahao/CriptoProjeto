package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoExtremo;
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

@Transactional
@Controller
@EnableScheduling
public class HistBusiness {
    @Autowired
    GsonReceiver gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl moedaDao;

    @Scheduled(cron = "00 00 00 * * ?")
    public void insereTabValorCripto() {
        moedaDao.adicionarCriptoValorHistorico();

    }
}
