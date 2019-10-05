/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.torneodelpodermodel.dto;

/**
 *
 * @author sarayar
 */
public class Guerrero {
    private int id;
    private String nombre;
    private String raza;
    private String planetaOrigen;
    private int poderDePelea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPlanetaOrigen() {
        return planetaOrigen;
    }

    public void setPlanetaOrigen(String planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    public int getPoderDePelea() {
        return poderDePelea;
    }

    public void setPoderDePelea(int poderDePelea) {
        this.poderDePelea = poderDePelea;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.planetaOrigen;
    }
    
    
    
}









