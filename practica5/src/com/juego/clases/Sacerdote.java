package com.juego.clases;

import com.juego.habilidades.CuraCuerpoAcuerpo;

public class Sacerdote extends Clases{
    public Sacerdote(){
        super(
                95,
                0,
                0,
                3
        );
    }
    CuraCuerpoAcuerpo pocionVidaGrande = new CuraCuerpoAcuerpo();
}
