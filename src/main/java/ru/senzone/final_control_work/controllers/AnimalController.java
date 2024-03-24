package ru.senzone.final_control_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.madols.Command;
import ru.senzone.final_control_work.sercices.AnimalService;

import java.util.List;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void addAnimal(String name, String type) {
        Animal animal = new Animal();
        animal.setName(name);
        animalService.addAnimal(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }
}
