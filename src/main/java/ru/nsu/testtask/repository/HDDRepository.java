package ru.nsu.testtask.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.nsu.testtask.data.entity.HDD;

@Repository
@Qualifier("hddRepository")
public interface HDDRepository extends ProductRepository<HDD, Integer> {
}
