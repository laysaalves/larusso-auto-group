package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.enuns.CarBrand;
import dev.layseiras.larussoautogroup.infra.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepo;

    public Car createNewCar(Car car){
        return carRepo.save(car);
    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }

    public Car getCarByBrand(CarBrand brand){
        return carRepo.findByBrand(brand);
    }

    public Car getCarById(Long id){
        return carRepo.findById(id).orElse(null);
    }
}
