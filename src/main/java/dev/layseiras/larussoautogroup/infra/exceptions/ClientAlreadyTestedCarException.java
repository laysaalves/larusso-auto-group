package dev.layseiras.larussoautogroup.infra.exceptions;

public class ClientAlreadyTestedCarException extends RuntimeException {
    public ClientAlreadyTestedCarException(String message) {
        super(message);
    }
}
