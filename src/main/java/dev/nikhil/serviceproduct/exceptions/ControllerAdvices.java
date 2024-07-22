package dev.nikhil.serviceproduct.exceptions;

import dev.nikhil.serviceproduct.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvices {
  /*  @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundExceptions
            (NotFoundException notFoundException)
    {
        return new ResponseEntity(new ExceptionDto (HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }*/
}
