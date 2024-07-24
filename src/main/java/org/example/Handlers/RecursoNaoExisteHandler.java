package org.example.Handlers;

import org.example.Exceptions.RecursoJaExiste;
import org.example.Exceptions.RecursoNaoExiste;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
public class RecursoNaoExisteHandler {

    @ExceptionHandler(RecursoNaoExiste.class)
    public ResponseEntity<String> lancarErroRecursoNaoExistente(@RequestBody RecursoNaoExiste recursoNaoExiste){

        return new ResponseEntity<>(recursoNaoExiste.getMessage(), HttpStatus.NOT_FOUND);
    }
}
