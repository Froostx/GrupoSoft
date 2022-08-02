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
import uy.gruposoft.excepciones.LocalException;
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.logica.Local;
import uy.gruposoft.logica.Locales;
import static uy.gruposoft.persistencia.PersistenciaUsuario.pst;

/**
 *
 * @author andressantucci
 */
public class PersistenciaLocal {
    
    private static final String all = "SELECT * FROM grupo_soft.locales WHERE fecha_baja IS NULL";
    private static final String insert = "INSERT INTO grupo_soft.locales (nro_local, negocio, encargado, fecha_alta) VALUES (?, ?, ?, current_timestamp())";
    private static final String verificar = "SELECT nro_local FROM grupo_soft.locales WHERE nro_local = ?";
    private static final String update = "UPDATE grupo_soft.locales SET negocio = ?, encargado = ? WHERE nro_local = ?";
    private static final String eliminar = "UPDATE grupo_soft.locales SET fecha_baja = current_timestamp() WHERE nro_local = ?";
    private static final String buscar = "SELECT * FROM grupo_soft.locales WHERE negocio LIKE ? '%' and fecha_baja IS NULL ORDER BY negocio";


    static Connection cn = null;
    static Conexion conexion = new Conexion();
    
    static PreparedStatement pst = null;
    
    public static Locales mostrarLocales() throws LocalException{
    
        Locales locales = new Locales();
        
        ResultSet rs = null;
        try{
            cn = Conexion.conectar();
            pst = cn.prepareStatement(all);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
            
                Local local = new Local();
                local.setNumeroLocal(rs.getInt("nro_local"));
                local.setNombreNegocio(rs.getString("negocio"));
                local.setEncargado(rs.getString("encargado"));
                local.setFechaAlta(rs.getDate("fecha_alta"));
                
                
                locales.agregarLocal(local);
               
            }
         
        } catch (SQLException e) {

            throw new LocalException("No pude cargar los locales");

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
               throw new LocalException("No pude insertar el Local");
            }
        }
    return locales;
    }
    
    
    
    
    
    public static void altaLocal(Local local) throws LocalException{
        try{
            
        cn = conexion.conectar();
        pst = cn.prepareStatement(insert);
        pst.setInt(1,local.getNumeroLocal());
        pst.setString(2, local.getNombreNegocio());
        pst.setString(3, local.getEncargado());
        
        pst.executeUpdate();

        } catch (SQLException e) {
            throw new LocalException("No pude insertar el local");
        }
    }
    
    
    public static boolean verificarLocal(Local local) throws LocalException
    {
        boolean existe = false;
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(verificar);
            pst.setInt(1, local.getNumeroLocal());
            
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                existe = true;
        
        } catch(SQLException  e){
            throw new LocalException("No encontre el local");
        }
    
        return existe;
    }
    
    
    
        public static void modificarLocal(Local local) throws LocalException {
       
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);

            pst.setString(1, local.getNombreNegocio());
            pst.setString(2, local.getEncargado());
            pst.setInt(3,local.getNumeroLocal());

            
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new LocalException("No se pudo modificar el Local");
        }

        }
        
        
        public static void eliminarLocal(Local local) throws LocalException{
            try{
                cn = conexion.conectar();
                pst = cn.prepareStatement(eliminar);
       
                pst.setInt(1, local.getNumeroLocal());
            
                pst.executeUpdate();
                
        }catch (SQLException e) {
            
             throw new LocalException("No pude Eliminar el local");
        }
            
        }
        
        
        
    public static Locales buscarLocales(Local local) throws LocalException {

        Locales locales = new Locales();
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(buscar);
            pst.setString(1, local.getNombreNegocio());
            rs = pst.executeQuery();

            while (rs.next()) {

                Local encontrado = new Local();
                encontrado.setNumeroLocal(rs.getInt("nro_local"));
                encontrado.setEncargado(rs.getString("encargado"));
                encontrado.setNombreNegocio(rs.getString("negocio"));
    
                encontrado.setFechaAlta(rs.getDate("fecha_alta"))  ;
               
               
                locales.agregarLocal(encontrado);

            }

        } catch (SQLException e) {

            throw new LocalException("No pude cargar los locales");

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
               throw new LocalException("No pude insertar el local");
            }
        }
        return locales;
    }        
        
       
}
