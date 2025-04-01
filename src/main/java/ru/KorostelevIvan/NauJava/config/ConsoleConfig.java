package ru.KorostelevIvan.NauJava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.KorostelevIvan.NauJava.controller.ConsoleController;

import java.util.Scanner;

@Configuration
public class ConsoleConfig {
    private ConsoleController consoleController;

    @Autowired
    public ConsoleConfig(ConsoleController consoleController) {
        this.consoleController = consoleController;
    }

    @Bean
    public CommandLineRunner commandScanner(){
        return args ->
        {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите команду. 'exit' для выхода.");
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    if("exit".equals(input.trim())){
                        System.out.println("Выход из программы");
                        break;
                    }
                    consoleController.processCommand(input);
                }
            }
        };
    }
}
