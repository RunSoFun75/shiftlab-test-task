package ru.nsu.bazarov.OnlineElectronicStore.Service;

import ru.nsu.bazarov.OnlineElectronicStore.Entity.HardDrive;
import ru.nsu.bazarov.OnlineElectronicStore.Repository.HardDriveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HardDriveService {

    @Autowired
    HardDriveRepository hardDriveRepository;

    public void save(HardDrive hardDrive) {
        hardDriveRepository.save(hardDrive);
        List<HardDrive> hardDrives = hardDriveRepository.findAll();
        for (HardDrive entity : hardDrives) {
            entity.setQuantityInStorage(hardDrives.size());
            hardDriveRepository.save(entity);
        }
    }

    public boolean update(Long id, HardDrive hardDrive) {
        Optional<HardDrive> editHardDrive = hardDriveRepository.findById(id);
        if (editHardDrive.isPresent()) {
            editHardDrive.get().setSerialNumber(hardDrive.getSerialNumber());
            editHardDrive.get().setProducer(hardDrive.getProducer());
            editHardDrive.get().setPrice(hardDrive.getPrice());
            editHardDrive.get().setCapacity(hardDrive.getCapacity());
            save(editHardDrive.get());
            return true;
        }
        return false;
    }

    public List<HardDrive> getAll() {
        return hardDriveRepository.findAll();
    }

    public Optional<HardDrive> getById(Long id) {
        return hardDriveRepository.findById(id);
    }
}
