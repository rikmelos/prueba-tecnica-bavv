package com.avvillas.palabrasdemo;

import com.avvillas.palabrasdemo.model.Palabra;
import com.avvillas.palabrasdemo.rest.PalabrasRest;
import com.avvillas.palabrasdemo.service.IValidacionPalabras;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PalabrasRest.class)
public class PalabrasRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IValidacionPalabras validacionPalabras;

    Palabra parPalabras = new Palabra("amor", "roma");

    String palabraJson = "{\"primerPalabra\":\"amor\",\"segundaPalabra\":\"roma\"}";

    @Test
    public void retrieveDetail() throws Exception{

        Mockito.when(
                validacionPalabras.solveValidation(Mockito.anyObject())).thenReturn(true);

        RequestBuilder rb = MockMvcRequestBuilders.post("/validar-palabras/")
                .accept(MediaType.APPLICATION_JSON)
                .content(palabraJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rb).andReturn();
        MockHttpServletResponse response = result.getResponse();


        System.out.println(result.getResponse().toString());
        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
    }
}
