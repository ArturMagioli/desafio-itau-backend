package com.magioli.desafiobackenditau.exception;

import com.magioli.desafiobackenditau.exception.criada.ArgumentoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoGlobalDeExcecoes {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarExcecao(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarExcecaoJsonInvalido() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> tratarExcecaoValidation() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
                .build();
    }

    @ExceptionHandler(ArgumentoInvalidoException.class)
    public ResponseEntity<Void> tratarExcecaoArgumentoInvalido() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
                .build();
    }

}
