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
import uy.gruposoft.logica.Pais;
import uy.gruposoft.logica.Paises;

/**
 *
 * @author Administrador
 */
public class PersistenciaAfiliado {

    private static final String sql = "SELECT * FROM afiliados WHERE fecha_baja IS NULL";
    private static final String cargarPaises = "SELECT * FROM grupo_soft.paises";
    private static final String insert = "INSERT INTO grupo_soft.afiliados (cedula,nombre,apellido,nacionalidad,direccion,telefono,mail,nacimiento,nro_local,propietario,fecha_alta) VALUES (?,?,?,?,?,?,?,?,?,?, current_timestamp())";
    private static final String update = "UPDATE grupo_soft.afiliados SET cedula = ?,nombre = ?,apellido = ?,nacionalidad = ?,direccion = ?,telefono = ?,mail = ?,nacimiento = ?,nro_local = ?, propietario = ?, fecha_alta = ? WHERE cedula = ?";
    private static final String buscar = "SELECT * FROM afiliados WHERE cedula LIKE CONCAT(?,'%') and fecha_baja IS NULL ORDER BY cedula";
    private static final String eliminar = "UPDATE grupo_soft.afiliados SET fecha_baja = current_timestamp() WHERE cedula = ?";
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
                afiliado.setNacimiento(rs.getDate("nacimiento"));
                afiliado.setNumeroLocal(rs.getInt("nro_local"));
                afiliado.setPropietario(rs.getString("propietario"));
                afiliado.setFechaAlta(rs.getDate("fecha_alta"));

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

    public static Paises cargarPais() throws AfiliadoException {
        Paises paises = new Paises();
        PreparedStatement ps = null;
        Pais p = null;
        ResultSet rs = null;
        cn = Conexion.conectar();
        try {
            ps = cn.prepareStatement(cargarPaises);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Pais();
                p.setPais(rs.getString("paises"));

                paises.agregarPais(p);

            }
        } catch (SQLException ex) {
            throw new AfiliadoException("No pude cargar los paises");
        }

        return paises;
    }

    public static void altaAfiliado(Afiliado afiliado) throws AfiliadoException {
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(insert);
            pst.setInt(1, afiliado.getCedula());
            pst.setString(2, afiliado.getNombre());
            pst.setString(3, afiliado.getApellido());
            pst.setString(4, afiliado.getNacionalidad());
            pst.setString(5, afiliado.getDireccion());
            pst.setString(6, afiliado.getTelefono());
            pst.setString(7, afiliado.getMail());
            pst.setDate(8, (java.sql.Date) afiliado.getNacimiento());
            pst.setInt(9, afiliado.getNumeroLocal());
            pst.setString(10, afiliado.getPropietario());

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliadoException("No pude insertar el usuario");
        } finally {
            try {

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }

            } catch (SQLException e) {
                throw new AfiliadoException("No pude cerrar la conexion ");

            }
        }
    }

    public static void modificarAfiliado(Afiliado afiliado) throws AfiliadoException {

        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(update);

            pst.setInt(1, afiliado.getCedula());
            pst.setString(2, afiliado.getNombre());
            pst.setString(3, afiliado.getApellido());
            pst.setString(4, afiliado.getNacionalidad());

            pst.setString(5, afiliado.getDireccion());
            pst.setString(6, afiliado.getTelefono());
            pst.setString(7, afiliado.getMail());
            pst.setDate(8, (java.sql.Date) afiliado.getNacimiento());
            pst.setInt(9, afiliado.getNumeroLocal());
            pst.setString(10, afiliado.getPropietario());
            pst.setDate(11, (java.sql.Date) afiliado.getFechaAlta());
            pst.setInt(12, afiliado.getCedula());

            pst.executeUpdate();
        } catch (SQLException e) {

            throw new AfiliadoException("No pude modificar el afiliado");
        }

    }

    public static Afiliados buscarAfiliados(Afiliado afiliadoEncontrado) throws AfiliadoException {

        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;

        try {
            cn = Conexion.conectar();

            pst = cn.prepareStatement(buscar);
            pst.setInt(1, afiliadoEncontrado.getCedula());

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
                afiliado.setNacimiento(rs.getDate("nacimiento"));
                afiliado.setNumeroLocal(rs.getInt("nro_local"));
                afiliado.setPropietario(rs.getString("propietario"));
                afiliado.setFechaAlta(rs.getDate("fecha_alta"));
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
    
    
    public static void bajaAfiliado(Afiliado afiliado) throws AfiliadoException {
        
        try{
            cn = conexion.conectar();
            pst = cn.prepareStatement(eliminar);
       
            pst.setInt(1, afiliado.getCedula());
            
            pst.executeUpdate();
        }catch (SQLException e) {
            
             throw new AfiliadoException("No pude Eliminar el afiliado");
        }
        
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
        
        
    }
}
