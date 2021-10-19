package ru.nsu.bazarov.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public final class Laptop extends Product {

    @Column(name = "diagonal")
    private int diagonal;
}
