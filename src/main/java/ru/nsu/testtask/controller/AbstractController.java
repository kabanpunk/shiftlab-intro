package ru.nsu.testtask.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.testtask.data.dto.DTO;
import ru.nsu.testtask.data.entity.ENTITY;
import ru.nsu.testtask.exception.NotFoundException;
import ru.nsu.testtask.mapper.AbstractMapper;
import ru.nsu.testtask.service.CrudService;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class AbstractController<E extends ENTITY, D extends DTO> {

    private final CrudService<E> service;
    private final AbstractMapper<E, D> abstractMapper;

    @GetMapping("/{id}")
    private ResponseEntity<D> get(@PathVariable("id") int id) {
        E entity = service.getById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id " + id));
        return new ResponseEntity<>(abstractMapper.toDTO(entity), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<E> create(@RequestBody D dto) {
        service.add(abstractMapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("entity with ID: {" + id + "} was deleted.", HttpStatus.OK);
    }

}
