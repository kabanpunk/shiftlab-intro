package ru.nsu.testtask.data.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.testtask.data.enums.ProductType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@DiscriminatorColumn
public class Product implements ENTITY{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Long serialNumber;

    private String producer;

    private Double price;

    private Integer stockQuantity;

    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    public Product() {}
}
