package ru.KorostelevIvan.NauJava.service;

import ru.KorostelevIvan.NauJava.entity.Student;

public interface StudentService {

    void addStudent(Integer id, String firstName, String lastName, String classLetter, Integer classYear);
    Student getStudent(Integer id);
    void updateStudent(Integer id, String firstName, String lastName, String classLetter, Integer classYear);
    void removeStudent(Integer id);
}
