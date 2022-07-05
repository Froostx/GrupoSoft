/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.logica.Usuario;

/**
 *
 * @author Administrador
 */
public class PersistenciaUsuario {

    public static DefaultTableModel mostrarUsuarios(String[] columnas) {
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
        String[] registros = new String[7];
        

       

        final String sql = "SELECT * FROM usuarios";

        Connection cn = null;

        PreparedStatement pst = null;
        //ArrayList<Usuario> usuarios= new ArrayList();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                //Usuario usuario=new Usuario();
                
                
                registros[0] = rs.getString("username");
                //usuario.setNombre(rs.getString("username"));

                registros[1] = rs.getString("nombre");

                registros[2] = rs.getString("apellido");

                registros[3] = rs.getString("email");
                registros[4] = rs.getString("contraseña");
                registros[5] = rs.getString("fecha_alta");
                registros[6] = rs.getString("fecha_baja");

              modelo.addRow(registros);
              //usuarios.add(usuario);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al conectar");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return modelo;
    }

    public static Boolean existeUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            final String sqlStm = "select * from usuarios where username='" + nombre + "' and contraseña='" + clave + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public void altaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void bajaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void modificacionUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

}
