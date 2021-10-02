package ru.nsu.bazarov.OnlineElectronicStore.Repository;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
