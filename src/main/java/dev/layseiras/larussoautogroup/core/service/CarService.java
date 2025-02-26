package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.infra.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepo;

    public Car createNewCar(Car car){
        return carRepo.save(car);
    }
}
