package ru.nsu.testtask.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.testtask.data.enums.ProductType;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class HDDDTO extends ProductDTO{

    @NotEmpty
    private Integer volume;

    public HDDDTO(Integer id, @NotEmpty String name, @NotEmpty Double price, @NotEmpty Integer stockQuantity, @NotEmpty ProductType type, @NotEmpty Integer volume) {
        super(id, name, price, stockQuantity, type);
        this.volume = volume;
    }
}
