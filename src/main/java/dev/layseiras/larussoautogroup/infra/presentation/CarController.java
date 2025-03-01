package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.enuns.CarBrand;
import dev.layseiras.larussoautogroup.core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car createNewCar(@RequestBody Car newCar){
        return carService.createNewCar(newCar);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/cars/{brand}")
    public ResponseEntity<Car> getCarByBrand(@PathVariable CarBrand brand){
        Car car = carService.getCarByBrand(brand);
        if(car != null){
            return ResponseEntity.ok().body(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
