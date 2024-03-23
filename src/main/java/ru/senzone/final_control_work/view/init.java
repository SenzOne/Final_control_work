package ru.senzone.final_control_work.view;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.senzone.final_control_work.controllers.AnimalController;

@Component
public class init {

    final
    AnimalController animalController;

    public init(AnimalController catController) {
        this.animalController = catController;
    }

    @PostConstruct
    public void addAnimals() {
        animalController.addCat("cat1", "cat");
        animalController.addDog("dogName", "dog");
    }
}
