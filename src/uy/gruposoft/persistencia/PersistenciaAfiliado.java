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
import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.logica.Afiliado;
import uy.gruposoft.logica.Afiliados;

/**
 *
 * @author Administrador
 */
public class PersistenciaAfiliado {
    
     private static final String sql = "SELECT * FROM afiliados WHERE fecha_baja IS NULL";
    
    
    static Connection cn = null;
    static Conexion conexion = new Conexion();

    static PreparedStatement pst = null;
    public static Afiliados mostrarAfiliados() throws AfiliadoException {

       

        
        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(rs.getInt("cedula"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setNacionalidad(rs.getString("nacionalidad"));
                afiliado.setDireccion(rs.getString("direccion"));
                afiliado.setTelefono(rs.getString("telefono"));
                
                afiliado.setMail(rs.getString("mail"));
                afiliado.setNacimiento(rs.getDate("nacimiento"))  ;
                afiliado.setNumeroLocal(rs.getInt("nro_local"))  ;
                afiliado.setPropietario(rs.getBoolean("propietario"))  ;
                afiliado.setFechaAlta(rs.getDate("fecha_alta"))  ;
               

                afiliados.agregarAfiliado(afiliado);

            }

        } catch (SQLException e) {

            throw new AfiliadoException("No pude cargar los afiliados");

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
               throw new AfiliadoException("No pude insertar el afiliado");
            }
        }
        return afiliados;
    }
}
