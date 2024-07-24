package org.example.Handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class BadRequestHandler {

    public ResponseEntity<String> lancarBadReques(@RequestBody HttpClientErrorException.BadRequest badRequest, HttpServletRequest request){

        return new ResponseEntity<>("Bad request para + " + request.getRequestURI(), HttpStatus.BAD_REQUEST);
    }
}
