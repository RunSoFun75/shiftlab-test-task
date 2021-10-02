package ru.nsu.bazarov.OnlineElectronicStore.Repository;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.Computer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
