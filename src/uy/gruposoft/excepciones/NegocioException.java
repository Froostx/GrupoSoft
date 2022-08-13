package uy.gruposoft.excepciones;

/**
 *
 * @author gdelgado
 */
public class NegocioException extends Exception {

    public NegocioException() {
    }

    public NegocioException(String msg) {
        super(msg);
    }
}
