package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
