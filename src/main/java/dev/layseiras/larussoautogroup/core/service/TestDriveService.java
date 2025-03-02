package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import dev.layseiras.larussoautogroup.infra.dtos.TestDriveResponse;
import dev.layseiras.larussoautogroup.infra.exceptions.CarNotFoundException;
import dev.layseiras.larussoautogroup.infra.exceptions.CarTestedConflictException;
import dev.layseiras.larussoautogroup.infra.persistence.CarRepository;
import dev.layseiras.larussoautogroup.infra.persistence.TestDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    @Autowired
    private TestDriveRepository testDriveRepo;

    @Autowired
    private CarRepository carRepo;

    public TestDriveResponse addNewTestDrive(Long carId) {
        Car car = carRepo.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));

        boolean testDriveExists = testDriveRepo.existsByCarTested(car);
        if (testDriveExists) {
            throw new CarTestedConflictException("Test drive already exists for this car!");
        }

        TestDrive testDrive = new TestDrive();
        testDrive.setCarTested(car);
        testDrive = testDriveRepo.save(testDrive);

        return new TestDriveResponse(testDrive.getId(), "Test drive agendado!");
    }

    public List<TestDrive> getAllTestDrives() {
        return testDriveRepo.findAll();
    }
}

