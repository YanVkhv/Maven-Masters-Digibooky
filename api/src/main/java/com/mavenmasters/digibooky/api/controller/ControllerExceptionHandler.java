package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.exceptions.DuplicateEmailOrInssException;
import com.mavenmasters.digibooky.service.exceptions.InvalidEmailAddressException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ExceptionHandler(DuplicateEmailOrInssException.class)
    protected void duplicateEmailOrInssException(DuplicateEmailOrInssException ex, HttpServletResponse response) throws IOException {
        response.sendError(406, ex.getMessage());
        logger.warn(ex.getMessage());
    }

    @ExceptionHandler(InvalidEmailAddressException.class)
    private void invalidEmailAddressException(InvalidEmailAddressException ex, HttpServletResponse response) throws IOException {
        response.sendError(412, ex.getMessage());
        logger.warn(ex.getMessage());
    }


}
