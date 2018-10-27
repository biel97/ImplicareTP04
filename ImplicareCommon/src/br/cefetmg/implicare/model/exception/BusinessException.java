package br.cefetmg.implicare.model.exception;

/**
 *
 * @author Gabriel
 */
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(BusinessException ex) {
        super(ex);
    }

}
