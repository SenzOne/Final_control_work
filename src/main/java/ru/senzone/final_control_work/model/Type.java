package ru.senzone.final_control_work.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeName", unique = true)
    private String typeName;


    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(getId(), type.getId()) && Objects.equals(getTypeName(), type.getTypeName()) && Objects.equals(getAnimals(), type.getAnimals());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeName(), getAnimals());
    }
}
