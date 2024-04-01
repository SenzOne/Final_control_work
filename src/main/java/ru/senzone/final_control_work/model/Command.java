package ru.senzone.final_control_work.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "commands")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String commandName;

    @ManyToMany(mappedBy = "commands")
    private List<Animal> animals;

    public Command(){}

    public Command(String commandName) {
        this.commandName = commandName;
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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(getId(), command.getId()) && Objects.equals(getCommandName(), command.getCommandName()) && Objects.equals(getAnimals(), command.getAnimals());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommandName(), getAnimals());
    }

    @Override
    public String toString() {
        return "commandName = '" + commandName + '\'';
    }
}
