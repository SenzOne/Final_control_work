package ru.senzone.final_control_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.senzone.final_control_work.model.Type;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findTypeByTypeName(String typeName);
}
