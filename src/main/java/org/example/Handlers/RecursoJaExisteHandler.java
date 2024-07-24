package org.example.Handlers;

import org.example.Exceptions.RecursoJaExiste;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
public class RecursoJaExisteHandler {

    @ExceptionHandler(RecursoJaExiste.class)
    public ResponseEntity<String> lancarErroRecursoExistente(@RequestBody RecursoJaExiste recursoJaExiste){

        return new ResponseEntity<>(recursoJaExiste.getMessage(), HttpStatus.CONFLICT);
    }
}
