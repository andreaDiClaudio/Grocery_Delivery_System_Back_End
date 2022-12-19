package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.VansNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Van;
import com.example.examprogramminggrocerydeliverysystembackend.repository.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class VanController {

    @Autowired
    VanRepository vanRepository;

    @GetMapping("/vans")
    public List<Van> getVans(){

        List<Van> vans = vanRepository.findAll();

        if (vans.isEmpty()){
            throw new VansNotFoundException();
        } else {
            return vans;
        }
    }
}