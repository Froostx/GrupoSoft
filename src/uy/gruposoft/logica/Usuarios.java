/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Usuarios {
    private ArrayList<Usuario> usuarios = new ArrayList();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    public void agregarUsuario(Usuario usuario){
    
    usuarios.add(usuario);
    }
    
    
    
}
