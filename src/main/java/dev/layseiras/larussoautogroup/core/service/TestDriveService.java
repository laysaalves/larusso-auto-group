package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import dev.layseiras.larussoautogroup.infra.dtos.TestDriveResponse;
import dev.layseiras.larussoautogroup.infra.exceptions.CarNotFoundException;
import dev.layseiras.larussoautogroup.infra.exceptions.CarTestedConflictException;
import dev.layseiras.larussoautogroup.infra.exceptions.ClientAlreadyTestedCarException;
import dev.layseiras.larussoautogroup.infra.exceptions.ClientNotFoundException;
import dev.layseiras.larussoautogroup.infra.persistence.CarRepository;
import dev.layseiras.larussoautogroup.infra.persistence.ClientRepository;
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

    @Autowired
    private ClientRepository clientRepo;

    public TestDriveResponse addNewTestDrive(Long carId, Long clientId) {
        Car car = carRepo.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));

        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));

        if (testDriveRepo.existsByCarTested(car)) {
            throw new CarTestedConflictException("Test drive already exists for this car!");
        }

        if (testDriveRepo.existsByClientTesterAndCarTested(client, car)) {
            throw new ClientAlreadyTestedCarException("Client has already tested this car!");
        }

        boolean testDriveExists = testDriveRepo.existsByCarTested(car);
        if (testDriveExists) {
            throw new CarTestedConflictException("Test drive already exists for this car!");
        }

        TestDrive testDrive = new TestDrive();
        testDrive.setCarTested(car);
        testDrive.setClientTester(client);

        testDrive = testDriveRepo.save(testDrive);

        return new TestDriveResponse(testDrive.getId(), "Test drive agendado para o cliente!");
    }

    public List<TestDrive> getAllTestDrives() {
        return testDriveRepo.findAll();
    }

    public TestDrive findByCarTested(Car carTested) {
        return testDriveRepo.findByCarTested(carTested).orElse(null);
    }
}

