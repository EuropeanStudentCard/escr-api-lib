package fr.lescrous.escr.exceptions;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
