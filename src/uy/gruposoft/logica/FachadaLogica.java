package uy.gruposoft.logica;

import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.excepciones.LocalException;
import uy.gruposoft.excepciones.UsuarioException;
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
    
 
}
