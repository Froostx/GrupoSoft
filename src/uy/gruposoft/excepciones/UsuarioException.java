/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.excepciones;

/**
 *
 * @author guill
 */
public class UsuarioException extends Exception {
    
    public UsuarioException(){
        
    }
    
    public UsuarioException(String msg) {
        super(msg);
    }
    
}
