package ru.senzone.final_control_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senzone.final_control_work.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
