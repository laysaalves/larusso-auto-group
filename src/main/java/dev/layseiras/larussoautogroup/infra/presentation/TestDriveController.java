package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import dev.layseiras.larussoautogroup.core.service.TestDriveService;
import dev.layseiras.larussoautogroup.infra.dtos.ErrorMessage;
import dev.layseiras.larussoautogroup.infra.dtos.TestDriveResponse;
import dev.layseiras.larussoautogroup.infra.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestDriveController {
    @Autowired
    private TestDriveService service;

    @PostMapping("/testdrives/{carId}/{clientId}/{sellerId}")
    public ResponseEntity<?> addNewTestDrive(@PathVariable Long carId, @PathVariable (required = false) Long clientId, @PathVariable (required = false) Long sellerId) {
        try {
            TestDriveResponse res = service.addNewTestDrive(carId, clientId, sellerId);
            if (res != null) {
                return ResponseEntity.ok(res);
            }
        } catch (CarNotFoundException | ClientNotFoundException | SellerNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        } catch (CarTestedConflictException | ClientAlreadyTestedCarException e) {
            return ResponseEntity.status(409).body(new ErrorMessage(e.getMessage()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/testdrives")
    public List<TestDrive> getAllTestDrives() {
        return service.getAllTestDrives();
    }

    @GetMapping("/testdrives/{carTested}")
    public ResponseEntity<TestDrive> getTestDriveByCarId(@PathVariable Car carTested) {
        TestDrive testDrive = service.findByCarTested(carTested);
        if (testDrive != null) {
            return ResponseEntity.ok().body(testDrive);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
