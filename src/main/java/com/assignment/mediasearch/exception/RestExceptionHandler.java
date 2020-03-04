package com.assignment.mediasearch.exception;

import com.assignment.mediasearch.gateways.google.BooksNotFoundException;
import com.assignment.mediasearch.gateways.iTunes.AlbumsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler({BooksNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(BooksNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler({AlbumsNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(AlbumsNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
