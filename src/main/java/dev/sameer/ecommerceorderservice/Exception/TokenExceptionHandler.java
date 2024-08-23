package dev.sameer.ecommerceorderservice.Exception;

import dev.sameer.ecommerceorderservice.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TokenExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionResponseDTO> handlesInvalidToken(InvalidTokenException invalidTokenException) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                invalidTokenException.getMessage(),
                401
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.UNAUTHORIZED);
    }


}
