package ru.nsu.testtask.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "HDD")
@DiscriminatorValue("H")
@AllArgsConstructor
public class HDD extends Product{

    @Column
    private Integer volume;

    public HDD() {}
}
