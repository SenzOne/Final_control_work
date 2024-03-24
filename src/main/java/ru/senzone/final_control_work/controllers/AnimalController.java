package ru.senzone.final_control_work.controllers;

import org.springframework.stereotype.Controller;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.madols.Command;
import ru.senzone.final_control_work.sercices.AnimalService;


import java.util.List;
import java.util.Optional;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController( AnimalService animalService) {
        this.animalService = animalService;
    }

    public void addAnimal(String animalName, int animalAge, String animalType, List<String> animalCommands) {
        animalService.addAnimal(animalName, animalAge, animalType, animalCommands);
    }

    public List<Animal> getAllAnimals() {
        return animalService.getAnimals();
    }

    public Optional<List<Command>> getAnimalCommand(Long id) {
        return animalService.getAnimalCommands(id);
    }

    public void addCommands(Long id, List<String> animalCommands){
        animalService.addCommands(id, animalCommands);
    }
}
