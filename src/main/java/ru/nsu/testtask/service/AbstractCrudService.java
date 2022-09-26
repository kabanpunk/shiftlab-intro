package ru.nsu.testtask.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.testtask.data.entity.Product;
import ru.nsu.testtask.repository.AbstractRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Getter
public abstract class AbstractCrudService<E extends Product> implements CrudService<E> {

    private final AbstractRepository<E, Integer> repository;

    @Override
    public void add(E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(E entity) {
        repository.save(entity);
    }

    @Override
    public Optional<E> getById(int id) { return repository.findById(id); }

}
