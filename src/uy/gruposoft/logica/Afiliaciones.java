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
public class Afiliaciones {
    private ArrayList<Afiliacion> afiliaciones = new ArrayList();

    public ArrayList<Afiliacion> getAfiliaciones() {
        return afiliaciones;
    }

    public void setAfiliaciones(ArrayList<Afiliacion> afiliaciones) {
        this.afiliaciones = afiliaciones;
    }
    public void agregarAfiliacion(Afiliacion afiliacion){
    
    afiliaciones.add(afiliacion);
    }
}
