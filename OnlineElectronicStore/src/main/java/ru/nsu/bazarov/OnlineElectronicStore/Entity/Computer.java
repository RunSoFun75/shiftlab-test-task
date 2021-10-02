package ru.nsu.bazarov.OnlineElectronicStore.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public final class Computer extends Product {

    @Column(name = "formFactor")
    private FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}
