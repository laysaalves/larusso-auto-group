package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import dev.layseiras.larussoautogroup.core.service.TestDriveService;
import dev.layseiras.larussoautogroup.infra.dtos.ErrorMessage;
import dev.layseiras.larussoautogroup.infra.dtos.TestDriveResponse;
import dev.layseiras.larussoautogroup.infra.exceptions.CarNotFoundException;
import dev.layseiras.larussoautogroup.infra.exceptions.CarTestedConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestDriveController {
    @Autowired
    private TestDriveService service;
    @Autowired
    private TestDriveService testDriveService;

    @PostMapping("/testdrives/{carId}")
    public ResponseEntity<?> addNewTestDrive(@PathVariable Long carId) {
        try {
            TestDriveResponse res = service.addNewTestDrive(carId);
            if (res != null) {
                return ResponseEntity.ok(res);
            }
        } catch (CarNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        } catch (CarTestedConflictException e) {
            return ResponseEntity.status(409).body(new ErrorMessage(e.getMessage()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/testdrives")
    public List<TestDrive> getAllTestDrives() {
        return testDriveService.getAllTestDrives();
    }
}
