package ru.nsu.testtask.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.testtask.data.dto.MonitorDTO;
import ru.nsu.testtask.data.entity.Monitor;

@Component
public class MonitorMapper implements AbstractMapper<Monitor, MonitorDTO> {

    @Override
    public Monitor toEntity(MonitorDTO dto){
        Monitor monitor = new Monitor();
        monitor.setName(dto.getName());
        monitor.setPrice(dto.getPrice());
        monitor.setStockQuantity(dto.getStockQuantity());
        monitor.setProductType(dto.getProductType());
        monitor.setDiagonal(dto.getDiagonal());

        if(dto.getId() != null){
            monitor.setId(dto.getId());
        }

        return monitor;
    }

    @Override
    public MonitorDTO toDTO(Monitor entity){
        return new MonitorDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStockQuantity(),
                entity.getProductType(),
                entity.getDiagonal()
        );
    }

}
