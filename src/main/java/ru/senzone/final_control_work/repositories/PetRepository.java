package ru.senzone.final_control_work.repositories;

import org.springframework.stereotype.Repository;
import ru.senzone.final_control_work.madols.Cat;
import ru.senzone.final_control_work.madols.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetRepository extends JpaRepository<Cat, Long> {
}
