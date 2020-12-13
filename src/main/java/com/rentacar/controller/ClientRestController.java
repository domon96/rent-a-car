package com.rentacar.controller;

import com.rentacar.model.Client;
import com.rentacar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/clients")
public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(path = "/add")
    public String addNewClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String password) {
        Client newClient = new Client();
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setEmail(email);
        newClient.setLogin(login);
        newClient.setPassword(password);

        clientRepository.save(newClient);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getClient(@PathVariable Long id) {
        return clientRepository.findById(id);
    }
}
