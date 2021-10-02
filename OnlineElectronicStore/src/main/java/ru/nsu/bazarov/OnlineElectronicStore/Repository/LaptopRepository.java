package ru.nsu.bazarov.OnlineElectronicStore.Repository;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.Laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
