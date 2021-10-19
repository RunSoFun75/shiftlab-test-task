package ru.nsu.bazarov.repository;

import ru.nsu.bazarov.entity.Laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
