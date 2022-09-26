package ru.nsu.testtask.service;

import org.springframework.stereotype.Service;
import ru.nsu.testtask.data.entity.Monitor;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.repository.MonitorRepository;

import java.util.List;

@Service
public class MonitorService extends AbstractCrudService<Monitor>{
    public MonitorService(MonitorRepository repository){
        super(repository);
    }

    public List<Monitor> findAllByType(ProductType type){
        MonitorRepository repository = (MonitorRepository) getRepository();
        return repository.findAllByProductType(type);
    }

}
