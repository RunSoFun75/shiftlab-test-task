package ru.nsu.bazarov.OnlineElectronicStore.Repository;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.HardDrive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
}
