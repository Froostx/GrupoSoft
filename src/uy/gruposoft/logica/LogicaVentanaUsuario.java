/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import javax.swing.table.DefaultTableModel;
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.persistencia.PersistenciaUsuario;

import uy.gruposoft.presentacion.VentanaDeUsuario;

/**
 *
 * @author guill
 */
public class LogicaVentanaUsuario {
    
    public static void mostrarUsuarios() 
    {
        PersistenciaUsuario logica = new PersistenciaUsuario();
        
         String[] nombresColumnas = {"username", "nombre", "apellido", "email", "contraseña", "fecha_alta", "fecha_baja"};
       
        
        VentanaDeUsuario.tabla.setModel(FachadaLogica.cargarUsuario(nombresColumnas));
        
        VentanaDeUsuario.tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(3).setPreferredWidth(160);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        VentanaDeUsuario.tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
    }
    
    
    
    
     
}
