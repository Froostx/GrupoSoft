/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.excepciones;

/**
 *
 * @author Administrador
 */
public class AfiliadoException extends Exception {

    /**
     * Creates a new instance of <code>AfiliadoException</code> without detail
     * message.
     */
    public AfiliadoException() {
    }

    /**
     * Constructs an instance of <code>AfiliadoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AfiliadoException(String msg) {
        super(msg);
    }
}
