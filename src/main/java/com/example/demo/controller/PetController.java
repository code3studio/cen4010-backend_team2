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
    @PostMapping("/{id}/play")
    public String playWithPet(@PathVariable Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            if (pet.getHappiness() < 100) {
                pet.setHappiness(Math.min(100, pet.getHappiness() + 15));
                pet.setEnergy(Math.max(0, pet.getEnergy() - 10));
                petRepository.save(pet);
                return "You played with your pet!";
            } else {
                return "Your pet is already very happy!";
            }
        }
        return "Pet not found.";
    }
    @PostMapping("/{id}/clean")
    public String cleanPet(@PathVariable Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setHealth(Math.min(100, pet.getHealth() + 20));
            petRepository.save(pet);
            return "Pet cleaned and feeling better!";
        }
        return "Pet not found.";
    }
    @PostMapping("/{id}/emergency")
    public String emergencyVetVisit(@PathVariable Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setHealth(100);
            pet.setEnergy(100);
            pet.setHappiness(100);
            petRepository.save(pet);
            return "Emergency vet visit successful. Pet fully healed!";
        }
        return "Pet not found.";
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
