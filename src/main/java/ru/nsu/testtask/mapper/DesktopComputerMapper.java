package ru.nsu.testtask.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.testtask.data.dto.DesktopComputerDTO;
import ru.nsu.testtask.data.entity.DesktopComputer;

@Component
public class DesktopComputerMapper implements AbstractMapper<DesktopComputer, DesktopComputerDTO> {

    @Override
    public DesktopComputer toEntity(DesktopComputerDTO dto){
        DesktopComputer desktopComputer = new DesktopComputer();
        desktopComputer.setName(dto.getName());
        desktopComputer.setPrice(dto.getPrice());
        desktopComputer.setStockQuantity(dto.getStockQuantity());
        desktopComputer.setProductType(dto.getProductType());
        desktopComputer.setType(dto.getType());

        if(dto.getId() != null){
            desktopComputer.setId(dto.getId());
        }

        return desktopComputer;
    }

    @Override
    public DesktopComputerDTO toDTO(DesktopComputer entity){
        return new DesktopComputerDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStockQuantity(),
                entity.getProductType(),
                entity.getType()
        );
    }

}
