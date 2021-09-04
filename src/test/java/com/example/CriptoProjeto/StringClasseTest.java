package com.example.CriptoProjeto;

import org.junit.Assert;
import org.junit.Test;

public class StringClasseTest {

    StringClasse stringClasse = new StringClasse();

    @Test
    public void testarStringClasseRetornandoTrue(){
        //preparar massa de dados
        String mvn = "mvnDeveRetornarTrue";

        //Chamar o método
        boolean retorno = stringClasse.metodoInicial(mvn);

        //Verificar os Asserts
        Assert.assertTrue(retorno);
    }

    @Test
    public void testarStringClasseRetornandoFalse(){
        //preparar massa de dados
        String mvn = "DeveRetornarFalse";

        //Chamar o método
        boolean retorno = stringClasse.metodoInicial(mvn);

        //Verificar os Asserts
        Assert.assertFalse(retorno);
    }

}
