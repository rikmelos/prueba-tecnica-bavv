package com.avvillas.palabrasdemo.service.impl;

import com.avvillas.palabrasdemo.model.Palabra;
import com.avvillas.palabrasdemo.service.IValidacionPalabras;
import org.springframework.stereotype.Service;

@Service
public class ValidacionPalabrasImpl implements IValidacionPalabras {


    @Override
    public boolean solveValidation(Palabra parPalabras) {
        return isSameScenarios(parPalabras) ;
    }

    public boolean isSameScenarios(Palabra parPalabras) {

        String firstWord = parPalabras.getPrimeraPalabra();
        String secondWord = parPalabras.getSegundaPalabra();
        int match = 0;

        char[] charsOne = firstWord.toCharArray();
        char[] charsTwo = secondWord.toCharArray();

        for (int x = 0; x < charsOne.length; x++){
            for (int y = 0; y < charsTwo.length; y++){
                if(charsOne[x] == charsTwo[y]){
                    match++;
                }
            }
        }

        if(charsOne.length == match && charsOne.length == charsTwo.length){
            return true;
        }else{
            return false;
        }
    }

}
