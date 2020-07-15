package com.avvillas.palabrasdemo.rest;

import com.avvillas.palabrasdemo.model.Palabra;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static java.util.Objects.isNull;

@Controller
public class PalabrasRest {

    //@CrossOrigin
    @PostMapping(value = "/validar-palabras/", produces = "application/json")
    public ResponseEntity validar(@RequestBody final Palabra parPalabras) {


        if(!isNull(parPalabras)){
            parPalabras.getPrimeraPalabra();
            parPalabras.getSegundaPalabra();
        }

        

        boolean response = false;
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
