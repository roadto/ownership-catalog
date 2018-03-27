package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public class InvalidRequestParametersException extends RuntimeException {

    public InvalidRequestParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestParametersException(String message) {
        super(message);
    }
}
