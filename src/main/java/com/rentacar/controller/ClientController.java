package com.rentacar.controller;

import com.rentacar.model.Client;
import com.rentacar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public String addNewClient(@RequestParam String firstName,
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
    @ResponseBody
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Client> getClient(@PathVariable Long id) {
        return clientRepository.findById(id);
    }
}
