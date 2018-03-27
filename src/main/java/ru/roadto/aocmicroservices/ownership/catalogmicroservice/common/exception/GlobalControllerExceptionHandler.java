package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleException(NotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(InvalidRequestParametersException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public String handleException(InvalidResultException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleException(IllegalOperationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(DataIntegrityViolationException ex) {
        return ex.getMessage();
    }

}
