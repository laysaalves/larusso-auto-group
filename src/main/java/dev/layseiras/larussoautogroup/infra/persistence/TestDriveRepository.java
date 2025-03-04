package dev.layseiras.larussoautogroup.infra.persistence;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.core.entity.Seller;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
    boolean existsByCarTested(Car carTested);
    boolean existsByClientTesterAndCarTested(Client client, Car car);
    Optional<TestDrive> findByCarTested(Car carTested);
}
