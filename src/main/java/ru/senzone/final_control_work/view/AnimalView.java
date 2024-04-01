package ru.senzone.final_control_work.view;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.senzone.final_control_work.controller.AnimalController;
import ru.senzone.final_control_work.model.Animal;
import ru.senzone.final_control_work.model.Command;

import java.util.*;

@Component
public class AnimalView {


    private final AnimalController animalController;

    public AnimalView(AnimalController catController) {
        this.animalController = catController;
    }

    @PostConstruct
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Добавление нового животного");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новым командам");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimal();
                case 2 -> listCommands();
                case 3 -> trainAnimal();
                case 4 -> listAnimalsByBirthdate();
                case 5 -> showAnimalCount();
                case 0 -> running = false;
                default -> System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
        scanner.close();
    }

    private void showAnimalCount() {
        System.out.printf("Общее количество животных: %s \n", animalController.getTotalAnimalCount());
    }


    private void addAnimal() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя животного: ");
            String name = scanner.nextLine();

            System.out.println("Введите возраст животного: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Введите тип животного: ");
            String typeStr = scanner.nextLine();

            System.out.println("Введите команды животного через пробел: ");
            List<String> commandsStr = Arrays.asList(scanner.nextLine().split(" "));

            animalController.addAnimal(name, age, typeStr, commandsStr);
            System.out.println("Животное добавлено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: неверный формат данных.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при добавлении животного: " + e.getMessage());
        }
    }

    private void listCommands() {
        Scanner scanner = new Scanner(System.in);
        for (Animal animal : animalController.getAllAnimals()) {
            System.out.println(animal);
        }

        System.out.println("Укажи ID животного: ");
        Long id = scanner.nextLong();
        System.out.println("Список команд животного:");
        Optional<List<Command>> commandListOptional = animalController.getAnimalCommand(id);
        try {
            List<Command> commandList = commandListOptional.orElseThrow();
            for (Command command : commandList) {
                System.out.println(command);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Животное с указанным ID не найдено.");
        }
    }

    private void trainAnimal() {
        Scanner scanner = new Scanner(System.in);
        for (Animal animal : animalController.getAllAnimals()) {
            System.out.println(animal);
        }

        System.out.println("Укажи ID животного: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Введите команды животного через пробел: ");
        List<String> commandsStr = Arrays.asList(scanner.nextLine().split(" "));

        animalController.addCommands(id, commandsStr);
    }


    private void listAnimalsByBirthdate() {
        System.out.println("Список животных по дате рождения:");
        List<Animal> animals = animalController.getAllAnimals();
        animals.sort(Comparator.comparing(Animal::getAge));
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
