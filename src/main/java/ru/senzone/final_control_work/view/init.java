package ru.senzone.final_control_work.view;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.senzone.final_control_work.controllers.CatController;

@Component
public class init {

    final
    CatController catController;

    public init(CatController catController) {
        this.catController = catController;
    }

    @PostConstruct
    public void init() {
        catController.addPet();
    }
}
