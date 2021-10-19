package ru.nsu.bazarov.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public final class Monitor extends Product {

    @Column(name = "diagonal")
    private double diagonal;
}
