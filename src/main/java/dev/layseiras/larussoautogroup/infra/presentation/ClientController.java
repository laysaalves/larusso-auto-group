package dev.layseiras.larussoautogroup.infra.presentation;

import dev.layseiras.larussoautogroup.core.entity.Car;
import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.core.enuns.CarBrand;
import dev.layseiras.larussoautogroup.core.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public Client addNewClient(@RequestBody Client newClient) {
        return clientService.addNewClient(newClient);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok().body(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
