package ru.senzone.final_control_work.view;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.senzone.final_control_work.controllers.AnimalController;

@Component
public class AnimalView {


    private final AnimalController animalController;

    public AnimalView(AnimalController catController) {
        this.animalController = catController;
    }

    @PostConstruct
    public void addAnimals() {
        animalController.addAnimal("cat1", "cat");
        animalController.addAnimal("dogName", "dog");
        System.out.println(animalController.getAllAnimals());
    }
}
