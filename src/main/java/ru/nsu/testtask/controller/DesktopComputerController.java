package ru.nsu.testtask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.testtask.data.dto.DesktopComputerDTO;
import ru.nsu.testtask.data.entity.DesktopComputer;
import ru.nsu.testtask.data.enums.ProductType;
import ru.nsu.testtask.exception.NotFoundException;
import ru.nsu.testtask.mapper.AbstractMapper;
import ru.nsu.testtask.service.CrudService;
import ru.nsu.testtask.service.DesktopComputerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/desktopComputers")
public class DesktopComputerController extends AbstractController<DesktopComputer, DesktopComputerDTO> {
    public DesktopComputerController(CrudService<DesktopComputer> service, AbstractMapper<DesktopComputer, DesktopComputerDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping
    private ResponseEntity<List<DesktopComputerDTO>> getByType(){
        DesktopComputerService service = (DesktopComputerService) getService();
        List<DesktopComputerDTO> dtoList = service.findAllByType(ProductType.DESKTOP_COMPUTER).stream().map((e) -> getAbstractMapper().toDTO(e)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<DesktopComputerDTO> update(@PathVariable("id") int id, @RequestBody DesktopComputerDTO dto) {

        var desktopComputer = getService().getById(id)
                .orElseThrow(() -> new NotFoundException("The Desktop Computer with id " + id + " is not found"));

        desktopComputer.setName(dto.getName());
        desktopComputer.setPrice(dto.getPrice());
        desktopComputer.setStockQuantity(dto.getStockQuantity());
        desktopComputer.setProductType(dto.getProductType());
        desktopComputer.setType(dto.getType());
        getService().update(desktopComputer);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
