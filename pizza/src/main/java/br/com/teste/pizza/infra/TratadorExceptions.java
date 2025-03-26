package br.com.teste.pizza.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class TratadorExceptions {

    //aqui que coloca qual erro
    @ExceptionHandler(EntityNotFoundException.class)

    public ResponseEntity TratarException404() {
        return ResponseEntity.notFound().build();
    }


    //@ExceptionHandler(Exception.class)
   // public ResponseEntity TratarException500() {
     //   return ResponseEntity.internalServerError().build();
    //}

}
