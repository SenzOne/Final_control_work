package ru.senzone.final_control_work.sercices;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.senzone.final_control_work.madols.Cat;
import ru.senzone.final_control_work.madols.Pet;
import ru.senzone.final_control_work.repositories.PetRepository;

@Service
@Transactional
public class PetService {

    PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public void addPet(Cat cat){
        petRepository.save(cat);
    }
}