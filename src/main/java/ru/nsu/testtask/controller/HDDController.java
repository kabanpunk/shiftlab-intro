package ru.nsu.testtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.testtask.data.dto.DesktopComputerDTO;
import ru.nsu.testtask.data.dto.HDDDTO;
import ru.nsu.testtask.data.dto.HDDDTO;
import ru.nsu.testtask.data.entity.HDD;
import ru.nsu.testtask.data.entity.HDD;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.exception.NotFoundException;
import ru.nsu.testtask.mapper.AbstractMapper;
import ru.nsu.testtask.service.CrudService;
import ru.nsu.testtask.service.HDDService;
import ru.nsu.testtask.service.HDDService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/hdds")
public class HDDController extends AbstractController<HDD, HDDDTO> {
    public HDDController(CrudService<HDD> service, AbstractMapper<HDD, HDDDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping
    private ResponseEntity<List<HDDDTO>> getByType(){
        HDDService service = (HDDService) getService();
        List<HDDDTO> dtoList = service.findAllByType(ProductType.HDD).stream().map((e) -> getAbstractMapper().toDTO(e)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<HDDDTO> update(@PathVariable("id") int id, @RequestBody HDDDTO dto) {

        var hdd = getService().getById(id)
                .orElseThrow(() -> new NotFoundException("The HDD with id " + id + " is not found"));

        hdd.setName(dto.getName());
        hdd.setPrice(dto.getPrice());
        hdd.setStockQuantity(dto.getStockQuantity());
        hdd.setProductType(dto.getProductType());
        hdd.setVolume(dto.getVolume());
        getService().update(hdd);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
