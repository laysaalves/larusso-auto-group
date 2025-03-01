package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Seller;
import dev.layseiras.larussoautogroup.core.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/sellers")
    public Seller addNewSeller(@RequestBody Seller seller) {
        return sellerService.addNewSeller(seller);
    }
}
