package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Slf4j
public class ExceptionUtils {

    public static void throwNotFoundException(String message) {
        log.warn("NotFoundException: " + message);
        throw new NotFoundException(message);
    }

    public static void throwInvalidRequestParametersException(String message) {
        log.warn("InvalidRequestParametersException: " + message);
        throw new InvalidRequestParametersException(message);
    }

    public static void throwInvalidResultException(String message) {
        log.warn("InvalidResultException: " + message);
        throw new InvalidResultException(message);
    }

    public static void throwIllegalOperationException(String message) {
        log.warn("IllegalOperationException: " + message);
        throw new IllegalOperationException(message);
    }
}
