package ru.senzone.final_control_work.sercices;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.senzone.final_control_work.madols.Animal;
import ru.senzone.final_control_work.madols.Command;
import ru.senzone.final_control_work.madols.Type;
import ru.senzone.final_control_work.repositories.AnimalRepository;
import ru.senzone.final_control_work.repositories.CommandRepository;
import ru.senzone.final_control_work.repositories.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final TypeRepository typeRepository;
    private final CommandRepository commandRepository;

    public AnimalService(AnimalRepository animalRepository, TypeRepository typeRepository, CommandRepository commandRepository) {
        this.animalRepository = animalRepository;
        this.typeRepository = typeRepository;
        this.commandRepository = commandRepository;
    }

    public void addAnimal(String animalName, int animalAge, String animalType, List<String> animalCommands) {
        Optional<Type> existingType = typeRepository.findTypeByTypeName(animalType);
        Type type;

        if (existingType.isPresent()) {
            type = existingType.get();
        } else {
            type = new Type();
            type.setTypeName(animalType);
            typeRepository.save(type);
        }

        Animal animal = new Animal();
        animal.setName(animalName);
        animal.setAge(animalAge);
        animal.setType(type);

        List<Command> commandList = new ArrayList<>();
        for (String commandName : animalCommands) {
            Optional<Command> existingCommand = commandRepository.findTypeByCommandName(commandName);
            Command command;

            if (existingCommand.isPresent()) {
                command = existingCommand.get();
            } else {
                command = new Command(commandName);
                commandRepository.save(command);
            }
            commandList.add(command);
        }

        animal.setCommands(commandList);
        animalRepository.save(animal);
    }


    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Optional<List<Command>> getAnimalCommands(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.map(Animal::getCommands);
    }

    public void addCommands(Long id, List<String> animalCommands) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();

            List<Command> existingCommands = animal.getCommands();

            List<Command> newCommands = new ArrayList<>();
            for (String commandName : animalCommands) {
                Optional<Command> existingCommand = commandRepository.findTypeByCommandName(commandName);
                Command command;
                if (existingCommand.isPresent()) {
                    command = existingCommand.get();
                } else {
                    command = new Command(commandName);
                    commandRepository.save(command);
                }
                newCommands.add(command);
            }

            existingCommands.addAll(newCommands);
            animal.setCommands(existingCommands);

            animalRepository.save(animal);
        } else {
            throw new IllegalArgumentException("Animal not found with id: " + id);
        }
    }


}
