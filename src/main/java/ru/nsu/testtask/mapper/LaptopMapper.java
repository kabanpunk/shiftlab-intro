package ru.nsu.testtask.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.testtask.data.dto.LaptopDTO;
import ru.nsu.testtask.data.entity.Laptop;

@Component
public class LaptopMapper implements AbstractMapper<Laptop, LaptopDTO> {

    @Override
    public Laptop toEntity(LaptopDTO dto){
        Laptop laptop = new Laptop();
        laptop.setName(dto.getName());
        laptop.setPrice(dto.getPrice());
        laptop.setStockQuantity(dto.getStockQuantity());
        laptop.setProductType(dto.getProductType());
        laptop.setDiagonal(dto.getDiagonal());

        if(dto.getId() != null){
            laptop.setId(dto.getId());
        }

        return laptop;
    }

    @Override
    public LaptopDTO toDTO(Laptop entity){
        return new LaptopDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStockQuantity(),
                entity.getProductType(),
                entity.getDiagonal()
        );
    }

}
