package uy.gruposoft.persistencia;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uy.gruposoft.excepciones.NegocioException;
import uy.gruposoft.logica.Negocio;
import uy.gruposoft.logica.Negocios;
/**
 *
 * @author gdelgado
 */
public class PersistenciaNegocio {
    
    private static final String sql = "SELECT * FROM negocios WHERE fecha_baja IS NULL";
    private static final String update = "UPDATE grupo_soft.negocios SET cantidad_locales = ?, rubro = ?, marca = ? WHERE id = ?";
    private static final String insert = "INSERT INTO grupo_soft.negocios (cantidad_locales, rubro, marca, fecha_alta) VALUES (?, ?, ?, current_timestamp())";
    private static final String eliminar = "UPDATE grupo_soft.negocios SET fecha_baja = current_timestamp() WHERE id = ?";
    private static final String verificar = "SELECT marca FROM grupo_soft.negocios WHERE marca = ?";
    private static final String buscar = "SELECT * FROM grupo_soft.negocios WHERE marca LIKE ? '%' and fecha_baja IS NULL ORDER BY marca";
    
    static Connection cn = null;
    static Conexion conexion = new Conexion();

    static PreparedStatement pst = null;
    public static Negocios mostrarNegocios() throws NegocioException {

        Negocios negocios = new Negocios();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                Negocio negocio = new Negocio();
                negocio.setId(rs.getInt("id"));
                negocio.setCantidad_locales(rs.getInt("cantidad_locales"));
                negocio.setRubro(rs.getString("rubro"));
                negocio.setMarca(rs.getString("marca"));
                negocio.setFechaAlta(rs.getDate("fecha_alta"));

                negocios.agregarNegocio(negocio);
            }

        } catch (SQLException e) {

            throw new NegocioException("No pude cargar los negocios");

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
               throw new NegocioException("No pude insertar el negocio");
            }
        }
        return negocios;
    }

    public static Boolean existeNegocio(Negocio negocio) {

        Boolean resultado = false;

        Conexion con = new Conexion();
        String marca = negocio.getMarca();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            final String sqlStm = "select * from negocios where marca='" + marca;
            pst = conexion.prepareStatement(sqlStm);
            rs = pst.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public static void altaNegocio(Negocio negocio) throws NegocioException {
        
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(insert);
            pst.setInt(1,negocio.getCantidad_locales());
            pst.setString(2, negocio.getRubro());
            pst.setString(3, negocio.getMarca());
            
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new NegocioException("No pude insertar el negocio");
        } finally {
    }
    }

    public static void bajaNegocio(Negocio negocio) throws NegocioException {
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(eliminar);
       
            pst.setInt(1, negocio.getId());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new NegocioException("No pude Eliminar el negocio");
        }
    }

    public static void modificacionNegocio(Negocio negocio) throws NegocioException {
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);
           
            pst.setInt(1, negocio.getCantidad_locales());
            pst.setString(2, negocio.getRubro());
            pst.setString(3, negocio.getMarca());
            pst.setInt(4, negocio.getId());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new NegocioException("No pude modificar el negocio");
        }
    }
    
    
    public static boolean verificarUsuario(Negocio negocio)throws NegocioException {        
        boolean res = false;       
        
        try{
          cn=  conexion.conectar();
              
           pst = cn.prepareStatement(verificar);  
           pst.setString(1, negocio.getMarca());
           
            ResultSet rs = pst.executeQuery();        
            if(rs.next())
                res = true;
        } catch(SQLException  e){
            throw new NegocioException("No encontre el negocio");
        } 
        
        return res;
    }
    
    public static Negocios buscarNegocios(Negocio negocioEncontrado) throws NegocioException {
               
        Negocios negocios = new Negocios();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(buscar);
            pst.setString(1, negocioEncontrado.getMarca());
            rs = pst.executeQuery();

            while (rs.next()) {

                Negocio negocio = new Negocio();
                negocio.setId(rs.getInt("id"));
                negocio.setCantidad_locales(rs.getInt("cantidad_locales"));
                negocio.setRubro(rs.getString("rubro"));
                negocio.setMarca(rs.getString("marca"));
                negocio.setFechaAlta(rs.getDate("fecha_alta"))  ;
                              
                negocios.agregarNegocio(negocio);
            }
        } catch (SQLException e) {

            throw new NegocioException("No pude cargar los negocios");
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
               throw new NegocioException("No pude insertar el negocio");
            }
        }
        return negocios;
    }
    }
