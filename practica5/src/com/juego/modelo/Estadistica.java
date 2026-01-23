package com.juego.modelo;

public class Estadistica {
    private int vida;
    private int vidaMaxima;
    private int fuerza;
    private int destreza;
    private int inteligencia;

    public Estadistica(){
        //Vacio para que todas estén a 0
    }
    /// GETTERS
    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }
    ///SETTERS
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "vida=" + vida +
                ", fuerza=" + fuerza +
                ", destreza=" + destreza +
                ", inteligencia=" + inteligencia +
                '}';
    }
}