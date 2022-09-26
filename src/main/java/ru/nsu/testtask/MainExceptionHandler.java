package ru.nsu.testtask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.nsu.testtask.data.dto.ErrorDTO;
import ru.nsu.testtask.data.enums.ErrorType;
import ru.nsu.testtask.exception.NotFoundException;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(ErrorType.NOT_FOUND, exception.getMessage()));
    }

}
