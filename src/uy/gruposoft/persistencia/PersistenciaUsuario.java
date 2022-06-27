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
import uy.gruposoft.logica.LogicaUsuario;
import uy.gruposoft.logica.LogicaUsuarios;
/**
 *
 * @author Administrador
 */
public class PersistenciaUsuario {
    
    public LogicaUsuarios listaUsuarios() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        LogicaUsuarios usuarios = new LogicaUsuarios();

        return usuarios;

    }

    public static Boolean existeUsuario(LogicaUsuario usuario) {

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
            String sqlStm = "select * from usuario where usuario='" + nombre + "' and clave='" + clave + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public void altaUsuario(LogicaUsuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void bajaUsuario(LogicaUsuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void modificacionUsuario(LogicaUsuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }
    
    
    
    
}
