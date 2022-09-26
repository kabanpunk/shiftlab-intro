package ru.nsu.testtask.service;

import org.springframework.stereotype.Service;
import ru.nsu.testtask.data.entity.DesktopComputer;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.repository.DesktopComputerRepository;

import java.util.List;

@Service
public class DesktopComputerService extends AbstractCrudService<DesktopComputer>{
    public DesktopComputerService(DesktopComputerRepository repository) {
        super(repository);
    }

    public List<DesktopComputer> findAllByType(ProductType type){
        DesktopComputerRepository repository = (DesktopComputerRepository) getRepository();
        return repository.findAllByProductType(type);
    }

}
