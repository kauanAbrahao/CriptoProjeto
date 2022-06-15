package com.cripto.service;

import com.cripto.entity.dto.CriptoExtremoDTO;
import com.cripto.repository.CriptoExtremoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CriptoExtremoServiceTest {

    @Mock
    CriptoExtremoRepository criptoRepo;

    @Mock
    CoinGeckoRequestService coinGeckoRequestService;

    @InjectMocks
    CriptoExtremoService criptoExtremoService;

    private final String IDCRIPTO = "bitoin";

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTest_dtRefInvalida(){

        var response = criptoExtremoService.getAll(LocalDate.now());

        Mockito.verify(criptoRepo, Mockito.times(0)).getAllCriptoExtremo(Mockito.any(LocalDate.class));
        Assert.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    public void getAllTest_dtRefValida_retornoNulo(){
        Mockito.when(criptoRepo.getAllCriptoExtremo(Mockito.any(LocalDate.class)))
                .thenReturn(new ArrayList<>());

        var response = criptoExtremoService.getAll(LocalDate.now().minusDays(1));

        Mockito.verify(criptoRepo, Mockito.times(1)).getAllCriptoExtremo(Mockito.any(LocalDate.class));
        Assert.assertEquals(500, response.getStatusCode().value());
    }

    @Test
    public void getAlLTest_dtRefValida_retornaDTO(){
        Mockito.when(criptoRepo.getAllCriptoExtremo(Mockito.any(LocalDate.class)))
                .thenReturn(List.of(new CriptoExtremoDTO("bitcoin", new BigDecimal(20),  new BigDecimal(30), LocalDate.now().minusDays(5))));

        var response = criptoExtremoService.getAll(LocalDate.now().minusDays(1));

        Mockito.verify(criptoRepo, Mockito.times(1)).getAllCriptoExtremo(Mockito.any(LocalDate.class));
        Assert.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void getById_dtRefInvalida(){

        var response = criptoExtremoService.getById(LocalDate.now(), IDCRIPTO);

        Mockito.verify(criptoRepo, Mockito.times(0)).getAllCriptoExtremo(Mockito.any(LocalDate.class));
        Assert.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    public void retryGetCriptoExtremo(){
        criptoExtremoService.valoresExtremosFinalDoDia();
        Mockito.verify(criptoRepo, Mockito.times(0)).getAllCriptoExtremo(Mockito.any(LocalDate.class));
    }
}
