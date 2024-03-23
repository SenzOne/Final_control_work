package ru.senzone.final_control_work;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.senzone.final_control_work.controllers.CatController;

@SpringBootApplication
public class FinalControlWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalControlWorkApplication.class, args);
    }

}
