package ru.nsu.testtask.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.nsu.testtask.data.entity.Laptop;

@Repository
@Qualifier("laptopRepository")
public interface LaptopRepository extends ProductRepository<Laptop, Integer>{
}
