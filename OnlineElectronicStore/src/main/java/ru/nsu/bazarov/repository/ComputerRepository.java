package ru.nsu.bazarov.repository;

import ru.nsu.bazarov.entity.Computer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
