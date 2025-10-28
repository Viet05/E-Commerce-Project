package com.dnnviet.personal.project.CellphoneS.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handlingRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }
}
