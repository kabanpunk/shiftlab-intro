package ru.nsu.testtask.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.testtask.data.enums.LaptopDiagonal;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Laptop")
@AllArgsConstructor
@DiscriminatorValue("L")
public class Laptop extends Product{

    @Column
    @Enumerated(EnumType.STRING)
    private LaptopDiagonal diagonal;

    public Laptop() {}
}
