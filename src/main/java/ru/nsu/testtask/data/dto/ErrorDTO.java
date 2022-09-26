package ru.nsu.testtask.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.nsu.testtask.data.enums.ErrorType;

@Data
@AllArgsConstructor
public class ErrorDTO implements DTO {
    private ErrorType type;
    private String message;
}
