/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.excepciones;

/**
 *
 * @author andressantucci
 */
public class DeudorException extends Exception {

    /**
     * Creates a new instance of <code>DeudorException</code> without detail
     * message.
     */
    public DeudorException() {
    }

    /**
     * Constructs an instance of <code>DeudorException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DeudorException(String msg) {
        super(msg);
    }
}
