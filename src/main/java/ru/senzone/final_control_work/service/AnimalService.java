package ru.senzone.final_control_work.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.senzone.final_control_work.model.Animal;
import ru.senzone.final_control_work.model.Command;
import ru.senzone.final_control_work.model.Type;
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


    /**
     * Возвращает список всех животных из базы данных.
     *
     * @return список всех животных
     */
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }


    /**
     * Возвращает список команд для животного по его ID.
     *
     * @param id ID животного
     * @return список команд животного или пустой список, если животное не найдено
     */
    public Optional<List<Command>> getAnimalCommands(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.map(Animal::getCommands);
    }


    public Long getTotalAnimalCount() {
        return animalRepository.count();
    }


    /**
     * Добавляет нового животного в базу данных.
     * Если тип животного уже существует, использует существующий тип.
     * В противном случае создает новый тип и сохраняет его в базе данных.
     *
     * @param animalName имя животного
     * @param animalAge возраст животного
     * @param animalType тип животного
     * @param animalCommands список команд, которые может выполнять животное
     */
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
        animal.setCommands(addCommandsToRepository(animalCommands));
        animalRepository.save(animal);
    }


    /**
     * Добавляет список команд к животному по его ID.
     * Если животное не найдено, выбрасывает исключение EntityNotFoundException.
     *
     * @param id ID животного
     * @param animalCommands список команд для добавления
     */
    public void addCommands(Long id, List<String> animalCommands) {
        Optional<Animal> optionalAnimal = Optional.ofNullable(animalRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal with id " + id + " not found")));
        Animal animal = optionalAnimal.get();
        List<Command> existingCommands = animal.getCommands();
        existingCommands.addAll(addCommandsToRepository(animalCommands));
        animal.setCommands(existingCommands);
        animalRepository.save(animal);
    }


    /**
     * Добавляет список команд в репозиторий и возвращает список сохраненных команд.
     * Если команда уже существует, использует существующую команду.
     * В противном случае создает новую команду и сохраняет ее в репозиторий.
     *
     * @param animalCommands список команд для добавления
     * @return список сохраненных команд
     */
    public List<Command> addCommandsToRepository(List<String> animalCommands) {
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
        return newCommands;
    }
}
