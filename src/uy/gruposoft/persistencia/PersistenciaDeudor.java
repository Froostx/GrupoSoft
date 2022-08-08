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
import uy.gruposoft.excepciones.DeudorException;
import uy.gruposoft.logica.Deudor;
import uy.gruposoft.logica.Deudores;

/**
 *
 * @author andressantucci
 */
public class PersistenciaDeudor {
    
    
    
    private static final String all = "SELECT * FROM deudores";
    private static final String verificar = "SELECT ci_afiliado FROM grupo_soft.deudores WHERE ci_afiliado = ?";
    private static final String insert = "INSERT INTO grupo_soft.deudores (ci_afiliado, cant_meses) VALUES (?, ?)";
    private static final String eliminar = "DELETE FROM grupo_soft.deudores WHERE ci_afiliado = ?";
    private static final String update = "UPDATE grupo_soft.deudores SET cant_meses = ? WHERE ci_afiliado = ?";

    
    
    static Connection cn = null;
    static Conexion conexion = new Conexion();

    static PreparedStatement pst = null;
    
    
    
    
    public static Deudores mostrarDeudores() throws DeudorException, SQLException {

        Deudores deudores = new Deudores();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(all);

            rs = pst.executeQuery();

            while (rs.next()) {

                Deudor deudor = new Deudor();
                deudor.setCiAfiliado(rs.getInt("ci_afiliado"));
                deudor.setCantMeses(rs.getInt("cant_meses"));
               
                deudores.agregarDeudor(deudor);

            }

        } catch (SQLException e) {

            throw new DeudorException("No se pudo cargar los deudores");

        } finally {
           
                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }
  
        }
        return deudores;
    }
    
    
    public static boolean verificarDeudor(Deudor deudor) throws DeudorException
    {
        boolean existe = false;
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(verificar);
            pst.setInt(1, deudor.getCiAfiliado());
            
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                existe = true;
        
        } catch(SQLException  e){
            throw new DeudorException("No encontre el deudpr");
        }
    
        return existe;
    }
    
    public static void altaDeudor(Deudor deudor) throws DeudorException{
        try{
            
        cn = conexion.conectar();
        pst = cn.prepareStatement(insert);
        pst.setInt(1,deudor.getCiAfiliado());
        pst.setInt(2, deudor.getCantMeses());
        
        pst.executeUpdate();

        } catch (SQLException e) {
            throw new DeudorException("No pude insertar el deudor");
        }
    }
    
    public static void bajaDeudor(Deudor deudor) throws DeudorException{
        try{
            cn = conexion.conectar();
            pst= cn.prepareStatement(eliminar);
            pst.setInt(1, deudor.getCiAfiliado());
            
            pst.execute();
            
            
        } catch (SQLException e) {
            throw new DeudorException("No pude eliminar el deudor");
        }       
        
    } 
    
    
    public static void modificarDeuda(Deudor deudor)throws DeudorException {
      
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);
           
            pst.setInt(1, deudor.getCantMeses());
            pst.setInt(2, deudor.getCiAfiliado());
            
            pst.executeUpdate();
            
        }catch (SQLException e) {
            
             throw new DeudorException("No pude modificar la deuda");
        }
    }
    
}
