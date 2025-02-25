package dev.layseiras.larussoautogroup.persistence;

import dev.layseiras.larussoautogroup.core.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
