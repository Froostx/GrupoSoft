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
public class Locales {
    
    private ArrayList<Local> locales = new ArrayList();
    
    public ArrayList<Local> getLocales(){
        return locales;
    }
    
    public void setLocales(ArrayList<Local> locales){
        this.locales = locales;
    }
    
    public void agregarLocal(Local nuevo){
        locales.add(nuevo);
    }
    
}
