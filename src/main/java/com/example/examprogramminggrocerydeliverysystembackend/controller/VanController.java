package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.VanByIdNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.VansNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Van;
import com.example.examprogramminggrocerydeliverysystembackend.repository.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class VanController {

    @Autowired
    VanRepository vanRepository;

    //Tested on Postman
    @GetMapping("/vans")
    public List<Van> getVans() {

        List<Van> vans = vanRepository.findAll();

        if (vans.isEmpty()) {
            throw new VansNotFoundException();
        } else {
            return vans;
        }
    }


    //Tested on Postman
    @GetMapping("/van/{id}")
    public Van getVanById(@PathVariable("id") int id) {
        Optional<Van> van = vanRepository.findById(id);

        if (van.isPresent()) {
            return van.get();
        } else {
            throw new VanByIdNotFoundException(id);
        }
    }
}
