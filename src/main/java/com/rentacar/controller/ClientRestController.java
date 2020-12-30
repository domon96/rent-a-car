package com.rentacar.controller;

import com.rentacar.model.User;
import com.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/clients")
public class ClientRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addNewClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String password) {
        User newClient = new User();
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setEmail(email);
        newClient.setLogin(login);
        newClient.setPassword(password);

        userRepository.save(newClient);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllClients() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getClient(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}
