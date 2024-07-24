package org.example.Handlers;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
public class MismatchHandler {

    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<String> InputHandler(@RequestBody MismatchedInputException mismatchedInputException){

        return new ResponseEntity<>("Iput inválido para " + mismatchedInputException.getPath() + " reavalie-o", HttpStatus.BAD_REQUEST);
    }
}
