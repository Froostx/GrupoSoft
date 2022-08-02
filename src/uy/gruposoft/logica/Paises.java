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
public class Paises {
   private ArrayList <Pais> paises = new ArrayList(); 

    public ArrayList <Pais> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList <Pais> paises) {
        this.paises = paises;
    }
    public void agregarPais(Pais pais){
        
        paises.add(pais);
    }
   
}
