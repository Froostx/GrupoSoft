package uy.gruposoft.logica;

import uy.gruposoft.excepciones.AfiliacionesException;
import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.excepciones.LocalException;
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.persistencia.PersistenciaAfiliaciones;
import uy.gruposoft.persistencia.PersistenciaAfiliado;
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
    
     public static void modificarAfiliado(Afiliado afiliado) throws AfiliadoException {

        PersistenciaAfiliado.modificarAfiliado(afiliado);

    }
     
      public static Afiliados buscarAfiliado(Afiliado afiliado) throws AfiliadoException {
        Afiliados afiliados = new Afiliados();
        afiliados = PersistenciaAfiliado.buscarAfiliados(afiliado);

        return afiliados;
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
      
      
   

}
