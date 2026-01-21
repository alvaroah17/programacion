package com.juego.presentacion;

import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Combate {
    public Combate (){

    }
    public void iniciarCombate(Personaje jugador1, Personaje jugador2){
        while (jugador1.getEstadisticas().getVida()>0 && jugador2.getEstadisticas().getVida()>0){
            System.out.println("INICIO DEL COMBATE");
            System.out.println(jugador1.getNombre()+" "+jugador1.getEstadisticas().getVida()+"/"+jugador1.getEstadisticas().getVida());
            System.out.println("- HABILIDADES - ");
            for (int i = 0; i < jugador1.getListaHabilidades().size(); i++) {
                System.out.println(i+") "+jugador1.getListaHabilidades().get(i).getNombre());
            }
            Scanner sc= new Scanner(System.in);
            int opcionElegida= sc.nextInt();


        }
    }
}
