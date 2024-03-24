package ru.senzone.final_control_work.sercices;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.repositories.AnimalRepository;

import java.util.List;

@Service
@Transactional
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void addAnimal(Animal animal){
        animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }
}
