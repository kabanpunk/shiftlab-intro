package ru.nsu.testtask.service;

import org.springframework.stereotype.Service;
import ru.nsu.testtask.data.entity.HDD;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.repository.HDDRepository;

import java.util.List;

@Service
public class HDDService extends AbstractCrudService<HDD>{
    public HDDService(HDDRepository repository) {
        super(repository);
    }

    public List<HDD> findAllByType(ProductType type){
        HDDRepository repository = (HDDRepository) getRepository();
        return repository.findAllByProductType(type);
    }

}
