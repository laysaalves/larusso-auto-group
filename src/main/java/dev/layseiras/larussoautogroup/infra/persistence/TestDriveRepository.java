package dev.layseiras.larussoautogroup.infra.persistence;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
    boolean existsByCarTested(Car carTested);
    boolean existsByClientTesterAndCarTested(Client client, Car car);
}
