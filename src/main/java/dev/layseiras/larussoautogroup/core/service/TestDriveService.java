package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.core.entity.Seller;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import dev.layseiras.larussoautogroup.infra.dtos.TestDriveResponse;
import dev.layseiras.larussoautogroup.infra.exceptions.*;
import dev.layseiras.larussoautogroup.infra.persistence.CarRepository;
import dev.layseiras.larussoautogroup.infra.persistence.ClientRepository;
import dev.layseiras.larussoautogroup.infra.persistence.SellerRepository;
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

    @Autowired
    private SellerRepository sellerRepo;

    public TestDriveResponse addNewTestDrive(Long carId, Long clientId, Long sellerId) {
        Car car = carRepo.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));

        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));

        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(() -> new SellerNotFoundException("Seller not found"));

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
        testDrive.setSellerTester(seller);

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

