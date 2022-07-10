/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import static uy.gruposoft.presentacion.VentanaDeUsuario.tabla;

/**
 *
 * @author guill
 */
public class LogicaVentanaUsuario {
    
    
    public static void actualizarUsuarios(){
        int fila = tabla.getSelectedRow();
        
        int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
        
        String[] datos = new String[6];
        
        datos[0]  =  tabla.getValueAt(fila,1).toString();
        datos[1]  =  tabla.getValueAt(fila,2).toString();
        datos[2]  =  tabla.getValueAt(fila,3).toString();
        datos[3]  =  tabla.getValueAt(fila,4).toString();
        datos[4]  =  tabla.getValueAt(fila,5).toString();
        datos[5]  =  tabla.getValueAt(fila,6).toString();
        
        
        
        
        
        
       
    }

    
}
