package com.example.CriptoProjeto.business;

import com.cripto.CriptoProjetoApplication;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = CriptoProjetoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CriptoProjetoApplication.class)
public class CriptomoedaBusinessTest {

    @Autowired
    CriptomoedaBusiness criptomoedaBusiness;

    @Autowired
    GsonReceiver gsonReceiver;

    @Test
    public void buscaJsonCriptoValorSchedulerTest(){ }



}
