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
        // Проверяем существует ли тип животного с указанным именем
        Optional<Type> existingType = typeRepository.findTypeByTypeName(animalType);
        Type type;

        // Если тип уже существует, используем его, иначе создаем новый
        if (existingType.isPresent()) {
            type = existingType.get();
        } else {
            type = new Type();
            type.setTypeName(animalType);
            typeRepository.save(type);
        }

        // Создаем новое животное
        Animal animal = new Animal();
        animal.setName(animalName);
        animal.setAge(animalAge);
        animal.setType(type);

        // Создаем список команд для животного
        List<Command> commandList = new ArrayList<>();
        for (String commandName : animalCommands) {
            // Проверяем существует ли команда с таким именем
            Optional<Command> existingCommand = commandRepository.findTypeByCommandName(commandName);
            Command command;

            // Если команда уже существует, используем ее, иначе создаем новую
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
        List<Animal> animalList = animalRepository.findAll();
        return animalList;
    }

    public Optional<List<Command>> getAnimalCommands(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.map(Animal::getCommands);
    }
}
