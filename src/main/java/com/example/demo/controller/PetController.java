package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PostMapping("/{id}/feed")
    public String feedPet(@PathVariable Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            if (pet.getEnergy() < 81) {
                pet.setEnergy(Math.min(100, pet.getEnergy() + 20));
                pet.setHealth(Math.max(0, pet.getHealth() - 5));
                petRepository.save(pet);
                return "Pet fed successfully.";
            } else {
                return "Pet is not hungry enough to be fed.";
            }
        }
        return "Pet not found.";
    }
}
