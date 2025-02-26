package dev.layseiras.larussoautogroup.infra.persistence;

import dev.layseiras.larussoautogroup.core.entity.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
}
