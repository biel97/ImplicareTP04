package br.cefetmg.implicare.model.exception;

/**
 *
 * @author Gabriel
 */
public class PersistenceException extends Exception {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(PersistenceException ex) {
        super(ex);
    }

}
