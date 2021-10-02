package ru.nsu.bazarov.OnlineElectronicStore.Service;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.Monitor;
import ru.nsu.bazarov.OnlineElectronicStore.Repository.MonitorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    @Autowired
    MonitorRepository monitorRepository;

    public void save(Monitor monitor) {
        monitorRepository.save(monitor);
        List<Monitor> monitors = monitorRepository.findAll();
        for (Monitor entity : monitors) {
            entity.setQuantityInStorage(monitors.size());
            monitorRepository.save(entity);
        }
    }

    public boolean update(Long id, Monitor monitor) {
        Optional<Monitor> editMonitor = monitorRepository.findById(id);
        if (editMonitor.isPresent()) {
            editMonitor.get().setSerialNumber(monitor.getSerialNumber());
            editMonitor.get().setProducer(monitor.getProducer());
            editMonitor.get().setPrice(monitor.getPrice());
            editMonitor.get().setDiagonal(monitor.getDiagonal());
            save(editMonitor.get());
        }
        return false;
    }

    public List<Monitor> getAll() {
        return monitorRepository.findAll();
    }

    public Optional<Monitor> getById(Long id) {
        return monitorRepository.findById(id);
    }
}
