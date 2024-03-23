package ru.senzone.final_control_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.madols.Cat;
import ru.senzone.final_control_work.madols.Dog;
import ru.senzone.final_control_work.sercices.PetService;

@Controller
public class AnimalController {

    @Autowired
    PetService petService;

    public void addCat(String name, String type){
        Cat cat = new Cat();
        cat.setType(type);
        cat.setName(name);
        petService.addPet(cat);
    }

    public void addDog(String name, String type){
        Animal dog = new Dog();
        dog.setType(type);
        dog.setName(name);
        petService.addPet(dog);
    }
}
