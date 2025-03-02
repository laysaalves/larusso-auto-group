package dev.layseiras.larussoautogroup.infra.persistence;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.enuns.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByBrand(CarBrand brand);
    Optional<Car> findById(Long id);
}
