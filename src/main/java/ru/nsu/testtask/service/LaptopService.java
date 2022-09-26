package ru.nsu.testtask.service;

import org.springframework.stereotype.Service;
import ru.nsu.testtask.data.entity.Laptop;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.repository.LaptopRepository;

import java.util.List;

@Service
public class LaptopService extends AbstractCrudService<Laptop>{
    public LaptopService(LaptopRepository repository) {
        super(repository);
    }

    public List<Laptop> findAllByType(ProductType type){
        LaptopRepository repository = (LaptopRepository) getRepository();
        return repository.findAllByProductType(type);
    }

}
