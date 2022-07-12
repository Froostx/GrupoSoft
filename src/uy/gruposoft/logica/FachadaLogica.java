package uy.gruposoft.logica;

import java.util.ArrayList;
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

    public static ArrayList<Usuario> cargarUsuario() {
      
     ArrayList<Usuario> usuarios = new ArrayList();
        usuarios = PersistenciaUsuario.mostrarUsuarios();
        
        return usuarios;
    }
    
    public static void modificarUsuario(Usuario usuario) throws UsuarioException {

        PersistenciaUsuario.modificacionUsuario(usuario);
        
    }
    public static void eliminarUsuario(Usuario usuario) throws UsuarioException {

        PersistenciaUsuario.bajaUsuario(usuario);
    }
    

}
