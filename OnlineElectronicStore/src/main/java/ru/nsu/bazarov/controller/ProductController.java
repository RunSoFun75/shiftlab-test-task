package ru.nsu.bazarov.controller;

import ru.nsu.bazarov.entity.Computer;
import ru.nsu.bazarov.entity.HardDrive;
import ru.nsu.bazarov.entity.Laptop;
import ru.nsu.bazarov.entity.Monitor;
import ru.nsu.bazarov.service.ComputerService;
import ru.nsu.bazarov.service.HardDriveService;
import ru.nsu.bazarov.service.LaptopService;
import ru.nsu.bazarov.service.MonitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store/products")
public class ProductController {

    @Autowired
    ComputerService computerService;

    @Autowired
    HardDriveService hardDriveService;

    @Autowired
    LaptopService laptopService;

    @Autowired
    MonitorService monitorService;

    @Transactional
    @PostMapping(value = "/computers")
    public ResponseEntity<?> addComputer(@RequestBody Computer computer) {
        computerService.save(computer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(value = "/hardDrives")
    public ResponseEntity<?> addHardDrive(@RequestBody HardDrive hardDrive) {
        hardDriveService.save(hardDrive);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(value = "/laptops")
    public ResponseEntity<?> addLaptop(@RequestBody Laptop laptop) {
        laptopService.save(laptop);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(value = "/monitors")
    public ResponseEntity<?> addMonitor(@RequestBody Monitor monitor) {
        monitorService.save(monitor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/computers")
    public ResponseEntity<?> findAllComputer() {
        List<Computer> computers = computerService.getAll();
        return  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hardDrives")
    public ResponseEntity<?> findAllHardDrives() {
        List<HardDrive> hardDrives = hardDriveService.getAll();
        return  !hardDrives.isEmpty()
                ? new ResponseEntity<>(hardDrives, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/laptops")
    public ResponseEntity<?> findAllLaptops() {
        List<Laptop> laptops = laptopService.getAll();
        return  !laptops.isEmpty()
                ? new ResponseEntity<>(laptops, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/monitors")
    public ResponseEntity<?> findAllMonitors() {
        List<Monitor> monitors = monitorService.getAll();
        return  !monitors.isEmpty()
                ? new ResponseEntity<>(monitors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computer/{id}")
    public ResponseEntity<?> getComputerById(@PathVariable Long id) {
        Optional<Computer> computer = computerService.getById(id);
        return computer.isPresent()
                ? new ResponseEntity<>(computer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hardDrive/{id}")
    public ResponseEntity<?> getHardDriveById(@PathVariable Long id) {
        Optional<HardDrive> hardDrive = hardDriveService.getById(id);
        return hardDrive.isPresent()
                ? new ResponseEntity<>(hardDrive, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/laptop/{id}")
    public ResponseEntity<?> getLaptopById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopService.getById(id);
        return laptop.isPresent()
                ? new ResponseEntity<>(laptop, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/monitor/{id}")
    public ResponseEntity<?> getMonitorById(@PathVariable Long id) {
        Optional<Monitor> monitor = monitorService.getById(id);
        return monitor.isPresent()
                ? new ResponseEntity<>(monitor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/computer/{id}/edit")
    public ResponseEntity<?> editComputerById(@PathVariable Long id, @RequestBody Computer computer) {
        return computerService.update(id, computer)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/hardDrive/{id}/edit")
    public ResponseEntity<?> editHardDriveById(@PathVariable Long id, @RequestBody HardDrive hardDrive) {
        return hardDriveService.update(id, hardDrive)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/laptop/{id}/edit")
    public ResponseEntity<?> editLaptopById(@PathVariable Long id, @RequestBody Laptop laptop) {
        return laptopService.update(id, laptop)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/monitor/{id}/edit")
    public ResponseEntity<?> editLaptopById(@PathVariable Long id, @RequestBody Monitor monitor) {
        return monitorService.update(id, monitor)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
