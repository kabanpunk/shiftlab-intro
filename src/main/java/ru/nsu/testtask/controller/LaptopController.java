package ru.nsu.testtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.testtask.data.dto.DesktopComputerDTO;
import ru.nsu.testtask.data.dto.HDDDTO;
import ru.nsu.testtask.data.dto.LaptopDTO;
import ru.nsu.testtask.data.entity.DesktopComputer;
import ru.nsu.testtask.data.entity.HDD;
import ru.nsu.testtask.data.entity.Laptop;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.exception.NotFoundException;
import ru.nsu.testtask.mapper.AbstractMapper;
import ru.nsu.testtask.service.CrudService;
import ru.nsu.testtask.service.DesktopComputerService;
import ru.nsu.testtask.service.LaptopService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/laptops")
public class LaptopController extends AbstractController<Laptop, LaptopDTO> {
    public LaptopController(CrudService<Laptop> service, AbstractMapper<Laptop, LaptopDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping
    private ResponseEntity<List<LaptopDTO>> getByType(){
        LaptopService service = (LaptopService) getService();
        List<LaptopDTO> dtoList = service.findAllByType(ProductType.LAPTOP).stream().map((e) -> getAbstractMapper().toDTO(e)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<LaptopDTO> update(@PathVariable("id") int id, @RequestBody LaptopDTO dto) {

        var laptop = getService().getById(id)
                .orElseThrow(() -> new NotFoundException("The Laptop with id " + id + " is not found"));

        laptop.setName(dto.getName());
        laptop.setPrice(dto.getPrice());
        laptop.setStockQuantity(dto.getStockQuantity());
        laptop.setProductType(dto.getProductType());
        laptop.setDiagonal(dto.getDiagonal());
        getService().update(laptop);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
