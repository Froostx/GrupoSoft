/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.persistencia.PersistenciaUsuario;

import uy.gruposoft.presentacion.VentanaDeUsuario;
import static uy.gruposoft.presentacion.VentanaDeUsuario.tabla;

/**
 *
 * @author guill
 */
public class LogicaVentanaUsuario {

    public static void mostrarUsuarios() {

        String[] nombresColumnas = {"Usuario", "Nombre", "Apellido", "Email", "Contraseña", "Fecha Alta", "Fecha Baja"};
        ArrayList<Usuario> usuarios = FachadaLogica.cargarUsuario();
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < usuarios.size(); i++) {

            fila[0] = usuarios.get(i).getUsuario();
            fila[1] = usuarios.get(i).getNombre();
            fila[2] = usuarios.get(i).getApellido();
            fila[3] = usuarios.get(i).getEmail();
            fila[4] = usuarios.get(i).getClave();
            fila[5] = usuarios.get(i).getFechaAlta();
            fila[6] = usuarios.get(i).getFechaBaja();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
    }

}
