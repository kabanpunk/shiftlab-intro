package ru.nsu.testtask.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "Monitor")
@AllArgsConstructor
@DiscriminatorValue("M")
public class Monitor extends Product {

    @Column
    private Double diagonal;

    public Monitor() {}

}



