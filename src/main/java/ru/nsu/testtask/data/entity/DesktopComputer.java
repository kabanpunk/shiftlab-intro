package ru.nsu.testtask.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.testtask.data.enums.DesktopComputerFormFactor;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Desktop_Computer")
@DiscriminatorValue("DC")
@AllArgsConstructor
public class DesktopComputer extends Product{

    @Column
    @Enumerated(EnumType.STRING)
    private DesktopComputerFormFactor type;

    public DesktopComputer() {}

}
