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
public class LogicaUsuarios {
    
    ArrayList<LogicaUsuario> usuarios = new ArrayList();

    public ArrayList<LogicaUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<LogicaUsuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
