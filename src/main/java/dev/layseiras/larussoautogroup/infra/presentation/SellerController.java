package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Seller;
import dev.layseiras.larussoautogroup.core.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/sellers")
    public Seller addNewSeller(@RequestBody Seller seller) {
        return sellerService.addNewSeller(seller);
    }

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/sellers/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerService.getSellerById(id);
        if(seller != null) {
            return ResponseEntity.ok().body(seller);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
