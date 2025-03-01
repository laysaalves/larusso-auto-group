package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Seller;
import dev.layseiras.larussoautogroup.infra.persistence.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepo;

    public Seller addNewSeller(Seller seller) {
        return sellerRepo.save(seller);
    }
}
