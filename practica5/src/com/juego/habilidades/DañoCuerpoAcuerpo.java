package com.juego.habilidades;

public class DañoCuerpoAcuerpo implements Habilidades {
    private int daño;
    private int usos;

    public DañoCuerpoAcuerpo(int daño, int usos) {
        this.daño = daño;
        this.usos = usos + 5;

    }

    public boolean usosAtaques() {
        boolean quedanAtaques =true;
        for (int i = 0; i < 5; i++) {
            this.usos--;
            if (this.usos == 0) {
                quedanAtaques =false;
            }
        }
        return quedanAtaques;
    }
    @Override
    public void usarHabilidad() {
        this.usos--;
    }
}
