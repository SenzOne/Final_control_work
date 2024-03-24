package ru.senzone.final_control_work.madols;

import jakarta.persistence.*;

@Entity
@Table(name = "commands")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commandName;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Command(){}

    public Command(Long id, String commandName, Animal animal) {
        this.id = id;
        this.commandName = commandName;
        this.animal = animal;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
