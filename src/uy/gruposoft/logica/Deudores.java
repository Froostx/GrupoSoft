/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.ArrayList;

/**
 *
 * @author andressantucci
 */
public class Deudores {
 
    
    private ArrayList<Deudor> deudores = new ArrayList();
    
    public ArrayList<Deudor> getDeudores(){
        return deudores;
    }
    
    public void setDeudores(ArrayList<Deudor> deudores){
        this.deudores = deudores;
    }
    
    public void agregarDeudor(Deudor nuevo){
        deudores.add(nuevo);
    }
}
