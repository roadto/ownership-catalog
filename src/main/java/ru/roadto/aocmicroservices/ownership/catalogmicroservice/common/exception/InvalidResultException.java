package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public class InvalidResultException extends RuntimeException {
    public InvalidResultException(String message) {
        super(message);
    }
}
