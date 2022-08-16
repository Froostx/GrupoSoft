package uy.gruposoft.logica;


import uy.gruposoft.excepciones.AfiliacionesException;

import java.sql.SQLException;

import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.excepciones.DeudorException;
import uy.gruposoft.excepciones.LocalException;
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.persistencia.PersistenciaAfiliaciones;
import uy.gruposoft.persistencia.PersistenciaAfiliado;
import uy.gruposoft.persistencia.PersistenciaDeudor;
import uy.gruposoft.persistencia.PersistenciaLocal;
import uy.gruposoft.persistencia.PersistenciaUsuario;

public class FachadaLogica {

    public static Boolean existeUsuario(Usuario usuario) {

        Boolean existe = false;
        existe = PersistenciaUsuario.existeUsuario(usuario);
        return existe;
    }

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException {

        PersistenciaUsuario.altaUsuario(usuario);
    }

    public static Usuarios cargarUsuario() throws UsuarioException {
        Usuarios usuarios = new Usuarios();
        usuarios = PersistenciaUsuario.mostrarUsuarios();

        return usuarios;
    }

    public static void modificarUsuario(Usuario usuario) throws UsuarioException {

        PersistenciaUsuario.modificacionUsuario(usuario);

    }

    public static void eliminarUsuario(Usuario usuario) throws UsuarioException {

        PersistenciaUsuario.bajaUsuario(usuario);
    }

    public static boolean verificarUsuario(Usuario usuario) throws UsuarioException {
        boolean existeUsuario;
        existeUsuario = PersistenciaUsuario.verificarUsuario(usuario);

        return existeUsuario;
    }
    
    
    public static Usuarios buscarUsuario(Usuario usuario) throws UsuarioException {
        Usuarios usuarios = new Usuarios();
        usuarios = PersistenciaUsuario.buscarUsuarios(usuario);

        return usuarios;
    }
    
    
    // Locales:
    
    
    public static Locales cargarLocales() throws LocalException {
     Locales locales = new Locales();
     locales = PersistenciaLocal.mostrarLocales();

     return locales;
    }
    
    public static boolean verificarLocal(Local local) throws LocalException{
        
        boolean existeLocal = PersistenciaLocal.verificarLocal(local);
        
        return existeLocal;
        
    }
    
    public static void insertarLocal(Local local) throws LocalException{
        PersistenciaLocal.altaLocal(local);
    }
    
    public static void modificarLocal(Local local) throws LocalException {

    PersistenciaLocal.modificarLocal(local);

    }
    
    public static void eliminarLocal(Local local) throws LocalException{
        PersistenciaLocal.eliminarLocal(local);
    }

    public static Locales buscarLocal(Local local) throws LocalException {
        Locales locales = new Locales();
        locales = PersistenciaLocal.buscarLocales(local);

        return locales;
    }
    
    
    //Afiliados:
    
    
    public static Afiliados cargarAfiliados() throws AfiliadoException{
        Afiliados afiliados = new Afiliados();
        afiliados = PersistenciaAfiliado.mostrarAfiliados();
        
        return afiliados;
    }
    
    public static Paises cargarPaises() throws AfiliadoException{
        Paises paises = new Paises();
        paises = PersistenciaAfiliado.cargarPais();
        
        return paises;
    }
    
    public static void insertarAfiliado(Afiliado afiliado) throws AfiliadoException{
        PersistenciaAfiliado.altaAfiliado(afiliado);
    }
    
<<<<<<< HEAD
    public static void modificarAfiliado(Afiliado afiliado) throws AfiliadoException {

        PersistenciaAfiliado.modificarAfiliado(afiliado);

    }
     
      public static Afiliados buscarAfiliado(Afiliado afiliado) throws AfiliadoException {
        Afiliados afiliados = new Afiliados();
        afiliados = PersistenciaAfiliado.buscarAfiliados(afiliado);

        return afiliados;
    }
      
    
    
    
    // Negocios:
    
    public static Negocios cargarNegocios() throws NegocioException {
     Negocios negocios = new Negocios();
     negocios = PersistenciaNegocio.mostrarNegocios();

     return negocios;
    }
    
    public static boolean verificarNegocio(Negocio negocio) throws NegocioException{
        
        boolean existeNegocio = PersistenciaNegocio.existeNegocio(negocio);
        
        return existeNegocio;
    }
    
    public static void insertarNegocio(Negocio negocio) throws NegocioException{
        PersistenciaNegocio.altaNegocio(negocio);
    }
    
    public static void modificarNegocio(Negocio negocio) throws NegocioException {

    PersistenciaNegocio.modificacionNegocio(negocio);

    }
    
    public static void eliminarNegocio(Negocio negocio) throws NegocioException{
        PersistenciaNegocio.bajaNegocio(negocio);
    }

    public static Negocios buscarNegocio(Negocio negocio) throws NegocioException {
        Negocios negocios = new Negocios();
        negocios = PersistenciaNegocio.buscarNegocios(negocio);
        return negocios;
=======

     public static void modificarAfiliado(Afiliado afiliado) throws AfiliadoException {

        PersistenciaAfiliado.modificarAfiliado(afiliado);

>>>>>>> parent of 5160dd6 (Merge branch 'main' of https://github.com/Froostx/GrupoSoft)
    }

     
      public static void eliminarAfiliado(Afiliado afiliado) throws AfiliadoException {

        PersistenciaAfiliado.bajaAfiliado(afiliado);
    }
      
      //afiliaciones
      
      public static Afiliaciones cargarAfiliaciones() throws AfiliacionesException{
          
        Afiliaciones afiliaciones = new Afiliaciones();
        afiliaciones = PersistenciaAfiliaciones.mostrarAfiliaciones();
        
        return afiliaciones;
    }
      
      public static void insertarAfiliacion(Afiliacion afiliacion) throws AfiliacionesException{
        PersistenciaAfiliaciones.altaAfiliaciones(afiliacion);
    }
      
       public static void modificarAfiliacion(Afiliacion afiliacion) throws AfiliacionesException {

        PersistenciaAfiliaciones.modificarAfiliaciones(afiliacion);

    }
      
      
   

    
   // deudores
    
        public static Deudores cargarDeudores() throws DeudorException, SQLException{
        Deudores deudores = new Deudores();
        deudores = PersistenciaDeudor.mostrarDeudores();
        
        return deudores;
    }
        
    public static boolean verificarDeudor(Deudor deudor) throws DeudorException {
        boolean existeDeudor;
        existeDeudor = PersistenciaDeudor.verificarDeudor(deudor);

        return existeDeudor;
    }
    
    public static void insertarDeudor(Deudor deudor) throws DeudorException{
        PersistenciaDeudor.altaDeudor(deudor);
    }
    
    public static void eliminarDeudor(Deudor deudor) throws DeudorException {

        PersistenciaDeudor.bajaDeudor(deudor);
    }
    
    public static void modificarDeuda(Deudor deudor) throws DeudorException{
        
        PersistenciaDeudor.modificarDeuda(deudor);
        
    
    }
    
    


<<<<<<< HEAD
     
    
=======

>>>>>>> parent of 5160dd6 (Merge branch 'main' of https://github.com/Froostx/GrupoSoft)
}
