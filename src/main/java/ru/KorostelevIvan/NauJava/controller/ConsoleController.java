package ru.KorostelevIvan.NauJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.KorostelevIvan.NauJava.service.StudentService;

@Component
public class ConsoleController {
    private final StudentService studentService;

    @Autowired
    public ConsoleController(StudentService studentService) {
        this.studentService = studentService;
    }
    public void processCommand(String input) {
        String[] cmd = input.split(" ");

        try {
            switch (cmd[0]) {
                case "add":
                    studentService.addStudent(Integer.parseInt(cmd[1]), cmd[2], cmd[3], cmd[4], Integer.parseInt(cmd[5]));
                    System.out.println("Добавлен новый студент");
                    break;
                case "delete":
                    studentService.removeStudent(Integer.parseInt(cmd[1]));
                    System.out.println("Студент с id: " + cmd[1] + " удален");
                    break;

                case "update":
                    studentService.updateStudent(Integer.parseInt(cmd[1]), cmd[2], cmd[3], cmd[4], Integer.parseInt(cmd[5]));
                    System.out.println("Студент с id: " + cmd[1] + " обновлен");
                    break;

                case "get":
                    System.out.println(studentService.getStudent(Integer.parseInt(cmd[1])).toString());
                    break;

                default:
                    System.out.println("Команда не распознана");
                    break;
            }
        }catch (Exception e) {
        System.out.println("Ошибка выполнения команды");
        }
    }
}
