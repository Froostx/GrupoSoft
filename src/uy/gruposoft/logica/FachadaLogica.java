package uy.gruposoft.logica;

import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.persistencia.PersistenciaUsuario;

public class FachadaLogica {

    public static Boolean existeUsuario(Usuario usuario) {

        Boolean existe = false;
        existe = PersistenciaUsuario.existeUsuario(usuario);
        return existe;
    }

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException{

        //PersistenciaUsuario.ingresarUsuario(usuario);
    }

}