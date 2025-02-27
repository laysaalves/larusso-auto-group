package dev.layseiras.larussoautogroup.infra.persistence;

import dev.layseiras.larussoautogroup.core.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
