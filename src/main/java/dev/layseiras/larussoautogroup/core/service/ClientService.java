package dev.layseiras.larussoautogroup.core.service;

import dev.layseiras.larussoautogroup.core.entity.Client;
import dev.layseiras.larussoautogroup.infra.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepo;

    public Client addNewClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElseThrow();
    }
}
