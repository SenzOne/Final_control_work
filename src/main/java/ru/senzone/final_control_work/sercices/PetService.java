package ru.senzone.final_control_work.sercices;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.repositories.AnimalRepository;

@Service
@Transactional
public class PetService {

    AnimalRepository petRepository;

    @Autowired
    public PetService(AnimalRepository petRepository) {
        this.petRepository = petRepository;
    }

    public <T extends Animal> void addPet(T animal) {
        petRepository.save(animal);
    }
}