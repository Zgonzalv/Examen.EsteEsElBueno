package com.example.Examen.config;

import com.example.Examen.controller.ClienteInexistenteException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptioClienteHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ClienteInexistenteException.class })
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request) {
        return  handleExceptionInternal(ex, "Cliente not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}