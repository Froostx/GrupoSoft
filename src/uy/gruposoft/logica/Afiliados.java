/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Afiliados {
    private ArrayList<Afiliado> Afiliados = new ArrayList();

    public ArrayList<Afiliado> getAfiliados() {
        return Afiliados;
    }

    public void setAfiliados(ArrayList<Afiliado> Afiliados) {
        this.Afiliados = Afiliados;
    }
    
    
     public void agregarAfiliado(Afiliado afiliado){
    
    Afiliados.add(afiliado);
    }
    
}
