package com.avvillas.palabrasdemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Palabra {

    private String primeraPalabra;
    private String segundaPalabra;

    @JsonCreator
    public Palabra(@JsonProperty("primeraPalabra") final String primeraPalabra,
                   @JsonProperty("segundaPalabra") final String segundaPalabra) {
        this.primeraPalabra = primeraPalabra;
        this.segundaPalabra = segundaPalabra;
    }

    public String getPrimeraPalabra() {
        return primeraPalabra;
    }

    public String getSegundaPalabra() {
        return segundaPalabra;
    }

    public void setPrimeraPalabra(String primeraPalabra) {
        this.primeraPalabra = primeraPalabra;
    }

    public void setSegundaPalabra(String segundaPalabra) {
        this.segundaPalabra = segundaPalabra;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "primeraPalabra='" + primeraPalabra + '\'' +
                ", segundaPalabra='" + segundaPalabra + '\'' +
                '}';
    }

}
