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
public class AfiliacionesException extends Exception {

    /**
     * Creates a new instance of <code>AfiliacionesException</code> without
     * detail message.
     */
    public AfiliacionesException() {
    }

    /**
     * Constructs an instance of <code>AfiliacionesException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AfiliacionesException(String msg) {
        super(msg);
    }
}
