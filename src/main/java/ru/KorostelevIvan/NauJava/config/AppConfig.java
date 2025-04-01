package ru.KorostelevIvan.NauJava.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.KorostelevIvan.NauJava.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Student> studentContainer(){
        return new ArrayList<Student>();
    }

    @Bean
    public String appInfo() {
        return String.format("%s v%s", appName, appVersion);
    }

    @PostConstruct
    public void printAppInfo() {
        System.out.println("=================================");
        System.out.println("Application: " + appName);
        System.out.println("Version: " + appVersion);
        System.out.println("=================================");
    }
}
