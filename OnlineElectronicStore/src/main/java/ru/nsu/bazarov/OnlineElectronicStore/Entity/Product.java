package ru.nsu.bazarov.OnlineElectronicStore.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "producer")
    private String producer;

    @Column(name = "price")
    private long price;

    @Column(name = "quantityInStorage")
    private int quantityInStorage;
}
