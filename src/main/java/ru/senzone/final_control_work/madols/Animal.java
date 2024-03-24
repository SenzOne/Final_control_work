package ru.senzone.final_control_work.madols;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "animal")
    private List<Command> commands;

    @OneToOne(mappedBy = "animal")
    private Type type;

    public Animal() {
    }

    public Animal(String type, String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
               "id=" + id +
               ", type='" + type + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}
