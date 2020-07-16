package com.avvillas.palabrasdemo.rest;

import com.avvillas.palabrasdemo.model.Palabra;
import com.avvillas.palabrasdemo.service.IValidacionPalabras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static java.util.Objects.isNull;

@Controller
public class PalabrasRest {

    @Autowired
    private IValidacionPalabras validacionPalabras;

    @PostMapping(value = "/validar-palabras/", produces = "application/json")
    public ResponseEntity validar(@RequestBody final Palabra parPalabras) {

        boolean response = false;

        if(!isNull(parPalabras)){
            response = validacionPalabras.solveValidation(parPalabras);
        }

        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
