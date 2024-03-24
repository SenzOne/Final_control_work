package ru.senzone.final_control_work.utils;
//
//import org.springframework.stereotype.Component;
//import ru.senzone.final_control_work.madols.Animal;
//import ru.senzone.final_control_work.madols.Command;
//import ru.senzone.final_control_work.madols.Type;
//
//import java.util.List;
//
//@Component
//public class AnimalDataValidator {
//
//    public boolean validAddData(List<String> data) {
//        try {
//            Animal animal = new Animal();
//            Type type = new Type();
//            Command command = new Command();
//
//            animal.setName(data.get(0));
//            animal.setAge(Integer.parseInt(data.get(1)));
//
//            type.setTypeName(data.get(2));
//            animal.setType(type);
//
//            command.setCommandName(data.get(3));
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//}
