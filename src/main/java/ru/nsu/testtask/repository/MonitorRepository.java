package ru.nsu.testtask.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.nsu.testtask.data.entity.Monitor;

@Repository
@Primary
@Qualifier("monitorRepository")
public interface MonitorRepository extends ProductRepository<Monitor, Integer> {
}
