package ru.senzone.final_control_work.madols;

import jakarta.persistence.*;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "type")
    private String type;

    @Column(name = "pack_animal")
    private boolean packAnimal;

    public Type() {
    }

    public Type(String type, Animal animal, boolean packAnimal) {
        this.type = type;
        this.animal = animal;
        this.packAnimal = packAnimal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isPackAnimal() {
        return packAnimal;
    }

    public void setPackAnimal(boolean packAnimal) {
        this.packAnimal = packAnimal;
    }
}
