/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.Date;

/**
 *
 * @author andressantucci
 */
public class Local {
    private int numeroLocal;
    private String nombreNegocio;
    private Date fechaAlta;
    private String encargado;

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public void setNombreNegocio(String negocio) {
        this.nombreNegocio = negocio;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    
    public void setEncargado(String encargado){
        this.encargado = encargado;
    }
    
    public int getNumeroLocal() {
        return numeroLocal;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getEncargado() {
        return encargado;
    }
     
}


