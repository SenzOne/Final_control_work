package ru.senzone.final_control_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.senzone.final_control_work.madols.Cat;
import ru.senzone.final_control_work.sercices.PetService;

@Controller
public class CatController {

    @Autowired
    PetService petService;

    public void addPet(){
        Cat cat = new Cat();
        cat.setType("cat");
        cat.setName("Smudge");
        petService.addPet(cat);
    }
}
