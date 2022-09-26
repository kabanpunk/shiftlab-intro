package ru.nsu.testtask.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.testtask.data.dto.DTO;
import ru.nsu.testtask.data.entity.ENTITY;

@Component
public interface AbstractMapper<E extends ENTITY, D extends DTO>{
    E toEntity(D dto);
    D toDTO(E entity);
}
