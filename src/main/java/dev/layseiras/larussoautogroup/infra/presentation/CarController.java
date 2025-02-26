package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car createNewCar(@RequestBody Car newCar){
        return carService.createNewCar(newCar);
    }
}
