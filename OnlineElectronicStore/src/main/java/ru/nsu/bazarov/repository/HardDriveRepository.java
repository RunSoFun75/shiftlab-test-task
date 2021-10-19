package ru.nsu.bazarov.repository;

import ru.nsu.bazarov.entity.HardDrive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
}
