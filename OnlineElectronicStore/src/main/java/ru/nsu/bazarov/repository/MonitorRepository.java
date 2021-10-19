package ru.nsu.bazarov.repository;

import ru.nsu.bazarov.entity.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
