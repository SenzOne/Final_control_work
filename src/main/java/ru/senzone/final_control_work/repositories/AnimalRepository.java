package ru.senzone.final_control_work.repositories;

import org.springframework.stereotype.Repository;
import ru.senzone.final_control_work.madols.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

