package uy.gruposoft.logica;

import uy.gruposoft.excepciones.UsuarioException;
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
   

}
