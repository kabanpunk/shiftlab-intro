package ru.nsu.testtask.service;

import ru.nsu.testtask.data.entity.ENTITY;

import java.util.Optional;

public interface CrudService <E extends ENTITY>{

    void add(E entity);
    void delete(int id);
    void update(E entity);
    Optional<E> getById(int id);

}
