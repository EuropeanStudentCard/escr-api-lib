package fr.lescrous.escr.exceptions;

public class UnknownTechnicalException extends Exception {

    public UnknownTechnicalException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
