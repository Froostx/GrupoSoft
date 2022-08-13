/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.Date;

/**
 *
 * @author gdelgado
 */
public class Negocio {
    private int id;
    private int cantidad_locales;
    private String rubro;
    private String marca;
    private Date fechaAlta;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getCantidad_locales() {
	return cantidad_locales;
    }

    public void setCantidad_locales(int cantidad_locales) {
	this.cantidad_locales = cantidad_locales;
    }

    public String getRubro() {
	return rubro;
    }

    public void setRubro(String rubro) {
	this.rubro = rubro;
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public Date getFechaAlta() {
	return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
    }

    public void setCantidad_locales(String ctdadLocales) {
	throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
