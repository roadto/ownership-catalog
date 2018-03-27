package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public class IllegalOperationException extends RuntimeException {

    public IllegalOperationException(String message) {
        super(message);
    }
}
