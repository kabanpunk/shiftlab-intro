package ru.nsu.testtask.data.dto;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.testtask.data.enums.DesktopComputerFormFactor;
import ru.nsu.testtask.data.enums.ProductType;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DesktopComputerDTO extends ProductDTO {

    @NotEmpty
    private DesktopComputerFormFactor type;

    public DesktopComputerDTO(Integer id, @NotEmpty String name, @NotEmpty Double price, @NotEmpty Integer stockQuantity, @NotEmpty ProductType type, @NotEmpty DesktopComputerFormFactor type1) {
        super(id, name, price, stockQuantity, type);
        this.type = type1;
    }
}
