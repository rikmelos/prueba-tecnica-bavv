package com.avvillas.palabrasdemo;

import com.avvillas.palabrasdemo.model.Palabra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class ValidacionPalabrasTest {

    Palabra palabraMock = mock( Palabra.class);

    @Test
    public void returnWithParameters() {
        when( palabraMock.getPrimeraPalabra() ).thenReturn("amor");
        assertEquals("amor", palabraMock.getPrimeraPalabra() );
        assertEquals( null , palabraMock.getSegundaPalabra() );

    }

    @Test
    public void returnWithGenericParameters() {
        when( palabraMock.getPrimeraPalabra() ).thenReturn("");
        when( palabraMock.getSegundaPalabra() ).thenReturn("");
        assertNotNull("", palabraMock.getPrimeraPalabra() );
        assertNotNull( "" , palabraMock.getSegundaPalabra() );

    }

    @Test
    public void verificationBasics() {

        String value1 = palabraMock.getPrimeraPalabra();

        verify(palabraMock).getPrimeraPalabra();
        verify(palabraMock, times(1)).getPrimeraPalabra();
    }

}
