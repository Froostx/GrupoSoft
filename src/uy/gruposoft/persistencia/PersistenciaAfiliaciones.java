/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uy.gruposoft.excepciones.AfiliacionesException;
import uy.gruposoft.logica.Afiliacion;
import uy.gruposoft.logica.Afiliaciones;
import uy.gruposoft.logica.RangoFechas;

/**
 *
 * @author Administrador
 */
public class PersistenciaAfiliaciones {
     private static final String sql = "SELECT * FROM afiliaciones WHERE fecha_baja IS NULL";
     private static final String insert = "INSERT INTO grupo_soft.afiliaciones (cedula,monto,fecha_pago) VALUES (?,?,current_timestamp())";
     private static final String update = "UPDATE grupo_soft.afiliaciones SET cedula = ?,monto = ?, fecha_pago = ? WHERE id = ?";
     private static final String eliminar = "UPDATE grupo_soft.afiliaciones SET fecha_baja = current_timestamp() WHERE id = ?";
     private static final String buscarPorFecha = "SELECT *FROM afiliaciones WHERE fecha_pago BETWEEN ? and ? and fecha_baja IS null";
     
     
     static Connection cn = null;
    static Conexion conexion = new Conexion();

    static PreparedStatement pst = null;
     public static Afiliaciones mostrarAfiliaciones() throws AfiliacionesException {

        Afiliaciones afiliaciones = new Afiliaciones();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                Afiliacion afiliacion = new Afiliacion();
                afiliacion.setId(rs.getInt("id"));
                afiliacion.setCedula(rs.getInt("cedula"));
                afiliacion.setMonto(rs.getInt("monto"));
                afiliacion.setFechaDePago(rs.getDate("fecha_pago"));

                afiliaciones.agregarAfiliacion(afiliacion);

            }

        } catch (SQLException e) {

            throw new AfiliacionesException("No pude cargar los afiliados");

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
                throw new AfiliacionesException("No pude insertar el afiliado");
            }
        }
        return afiliaciones;
    }
     
     
     
     
     public static void altaAfiliaciones(Afiliacion afiliacion) throws AfiliacionesException {
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(insert);
            pst.setInt(1, afiliacion.getCedula());
            pst.setInt(2, afiliacion.getMonto());
           
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionesException("No pude insertar el pago");
        } finally {
            try {

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }

            } catch (SQLException e) {
                throw new AfiliacionesException("No pude cerrar la conexion ");

            }
        }
    }
     
      public static void modificarAfiliaciones(Afiliacion afiliacion) throws AfiliacionesException {

        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);

            pst.setInt(1, afiliacion.getCedula());
            pst.setInt(2, afiliacion.getMonto());
            
            pst.setDate(3, (Date) afiliacion.getFechaDePago());
            pst.setInt(4, afiliacion.getId());
            
            
            pst.executeUpdate();
        } catch (SQLException e) {

            throw new AfiliacionesException("No pude modificar la afiliacion");
        }

    }
      
      public static void bajaAfiliacion(Afiliacion afiliacion) throws AfiliacionesException {
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(eliminar);
       
            pst.setInt(1, afiliacion.getId());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new AfiliacionesException("No pude Eliminar la afiliacion");
        }
        
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
        
        
    }
      public static  Afiliaciones buscarAfiliacion(RangoFechas rangoFechas) throws AfiliacionesException {
        Afiliaciones afiliaciones = new Afiliaciones();
         ResultSet rs = null; 
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(buscarPorFecha);
           
            
            pst.setDate(1, (java.sql.Date) rangoFechas.getFechaUno());
            pst.setDate(2, (java.sql.Date) rangoFechas.getFechaDos());
            
            
           rs = pst.executeQuery();
            
            
             while (rs.next()) {

                Afiliacion afiliacion = new Afiliacion();
                afiliacion.setId(rs.getInt("id"));
                afiliacion.setCedula(rs.getInt("cedula"));
                afiliacion.setMonto(rs.getInt("monto"));
                afiliacion.setFechaDePago(rs.getDate("fecha_pago"));

                afiliaciones.agregarAfiliacion(afiliacion);

            }
            
             } catch (SQLException e) {

            throw new AfiliacionesException("No pude cargar los afiliados");

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
                throw new AfiliacionesException("No pude insertar el afiliado");
            }
            
             
        
          return afiliaciones;
    }
        
      }
     
}
