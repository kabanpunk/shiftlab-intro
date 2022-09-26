package ru.nsu.testtask.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.nsu.testtask.data.entity.DesktopComputer;

@Repository
@Qualifier("desktopComputerRepository")
public interface DesktopComputerRepository extends ProductRepository<DesktopComputer, Integer>{
}
