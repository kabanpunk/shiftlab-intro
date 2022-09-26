package ru.nsu.testtask.repository;

import org.springframework.stereotype.Repository;
import ru.nsu.testtask.data.entity.Product;
import ru.nsu.testtask.data.enums.ProductType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository<E extends Product, Integer> extends AbstractRepository<E, Integer> {

    E getById(Integer integer);
    Optional<E> findProductById(Integer integer);
    List<E> findAllByProductType(ProductType type);

}
