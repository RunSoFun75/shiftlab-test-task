package ru.nsu.bazarov.OnlineElectronicStore.Service;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.Computer;
import ru.nsu.bazarov.OnlineElectronicStore.Repository.ComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    ComputerRepository computerRepository;

    public void save(Computer computer) {
        computerRepository.save(computer);
        List<Computer> computers = computerRepository.findAll();
        for (Computer entity : computers) {
            entity.setQuantityInStorage(computers.size());
            computerRepository.save(entity);
        }
    }

    public boolean update(Long id, Computer computer) {
        Optional<Computer> editComputer = computerRepository.findById(id);
        if (editComputer.isPresent()) {
            editComputer.get().setSerialNumber(computer.getSerialNumber());
            editComputer.get().setProducer(computer.getProducer());
            editComputer.get().setPrice(computer.getPrice());
            editComputer.get().setFormFactor(computer.getFormFactor());
            save(editComputer.get());
            return true;
        }
        return false;
    }

    public List<Computer> getAll() {
        return computerRepository.findAll();
    }

    public Optional<Computer> getById(Long id) {
        return computerRepository.findById(id);
    }
}
