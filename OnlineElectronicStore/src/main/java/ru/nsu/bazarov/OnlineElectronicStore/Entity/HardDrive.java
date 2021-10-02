package ru.nsu.bazarov.OnlineElectronicStore.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public final class HardDrive extends Product {

    @Column(name = "capacity")
    private String capacity;
}
