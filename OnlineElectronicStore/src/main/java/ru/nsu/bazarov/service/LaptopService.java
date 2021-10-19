package ru.nsu.bazarov.service;

import ru.nsu.bazarov.entity.Laptop;
import ru.nsu.bazarov.repository.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
        List<Laptop> laptops = laptopRepository.findAll();
        for (Laptop entity : laptops) {
            entity.setQuantityInStorage(laptops.size());
            laptopRepository.save(entity);
        }
    }

    public boolean update(Long id, Laptop laptop) {
        Optional<Laptop> editLaptop = laptopRepository.findById(id);
        if (editLaptop.isPresent()) {
            editLaptop.get().setSerialNumber(laptop.getSerialNumber());
            editLaptop.get().setProducer(laptop.getProducer());
            editLaptop.get().setPrice(laptop.getPrice());
            editLaptop.get().setDiagonal(laptop.getDiagonal());
            save(editLaptop.get());
        }
        return false;
    }

    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    public Optional<Laptop> getById(Long id) {
        return laptopRepository.findById(id);
    }
}
