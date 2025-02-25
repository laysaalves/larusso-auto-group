package dev.layseiras.larussoautogroup.persistence;

import dev.layseiras.larussoautogroup.core.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
