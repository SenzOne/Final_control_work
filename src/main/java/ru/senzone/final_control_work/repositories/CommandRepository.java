package ru.senzone.final_control_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senzone.final_control_work.model.Command;

import java.util.Optional;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
    Optional<Command> findTypeByCommandName(String CommandName);
}
