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
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.logica.Usuario;
import uy.gruposoft.logica.Usuarios;
/**
 *
 * @author Administrador
 */
public class PersistenciaUsuario {
    
    private static final String sql = "SELECT * FROM usuarios WHERE fecha_baja IS NULL";
    private static final String update = "UPDATE grupo_soft.usuarios SET username = ?, nombre = ?, apellido = ?, email = ?, contraseña = ? WHERE id = ?";
    private static final String insert = "INSERT INTO grupo_soft.usuarios (username, nombre,apellido,email,contraseña,fecha_alta) VALUES (?, ?, ?,?,?, current_timestamp())";
    private static final String eliminar = "UPDATE grupo_soft.usuarios SET fecha_baja = current_timestamp() WHERE id = ?";
    private static final String verificar = "SELECT username FROM grupo_soft.usuarios WHERE username = ?";
    private static final String buscar = "SELECT * FROM grupo_soft.usuarios WHERE username LIKE ? '%' and fecha_baja IS NULL ORDER BY username";
    
    static Connection cn = null;
    static Conexion conexion = new Conexion();

    static PreparedStatement pst = null;
    public static Usuarios mostrarUsuarios() throws UsuarioException {

       

        
        Usuarios usuarios = new Usuarios();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("username"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("Contraseña"));
                usuario.setFechaAlta(rs.getDate("fecha_alta"))  ;
               

                usuarios.agregarUsuario(usuario);

            }

        } catch (SQLException e) {

            throw new UsuarioException("No pude cargar los usuarios");

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
               throw new UsuarioException("No pude insertar el usuario");
            }
        }
        return usuarios;
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

       

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            final String sqlStm = "select * from usuarios where username='" + nombre + "' and contraseña='" + clave + "';";
            pst = conexion.prepareStatement(sqlStm);
            rs = pst.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public static void altaUsuario(Usuario usuario) throws UsuarioException {
        
            
        
        
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(insert);
            pst.setString(1,usuario.getUsuario() );
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getEmail());
            pst.setString(5, usuario.getClave());
            
            
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("No pude insertar el usuario");
        } finally {

        

    }
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public static void bajaUsuario(Usuario usuario) throws UsuarioException {
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(eliminar);
       
            pst.setInt(1, usuario.getId());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new UsuarioException("No pude Eliminar el usuario");
        }
        
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
        
        
    }

    public static void modificacionUsuario(Usuario usuario) throws UsuarioException {
       
        
       
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);
           
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getEmail());
            pst.setString(5, usuario.getClave());
            
             pst.setInt(6, usuario.getId());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new UsuarioException("No pude modificar el usuario");
        }
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }
    
    
    public static boolean verificarUsuario(Usuario usuario)throws UsuarioException {        
        boolean res = false;       
        
        try{
          cn=  conexion.conectar();
              
           pst = cn.prepareStatement(verificar);  
           pst.setString(1, usuario.getUsuario());
           
            ResultSet rs = pst.executeQuery();        
            if(rs.next())
                res = true;
        } catch(SQLException  e){
            throw new UsuarioException("No encontre el usuario");
        } 
        
        return res;
    }
    
    public static Usuarios buscarUsuarios(Usuario usuarioEncontrado) throws UsuarioException {
               
        Usuarios usuarios = new Usuarios();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(buscar);
            pst.setString(1, usuarioEncontrado.getUsuario());
            rs = pst.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("username"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("Contraseña"));
                usuario.setFechaAlta(rs.getDate("fecha_alta"))  ;
                              
                usuarios.agregarUsuario(usuario);
            }
        } catch (SQLException e) {

            throw new UsuarioException("No pude cargar los usuarios");
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
               throw new UsuarioException("No pude insertar el usuario");
            }
        }
        return usuarios;
    }
    
    
   
    }
    


