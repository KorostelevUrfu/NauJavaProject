package ru.KorostelevIvan.NauJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.KorostelevIvan.NauJava.entity.Student;
import ru.KorostelevIvan.NauJava.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Integer id, String firstName, String lastName, String classLetter, Integer classYear) {
        studentRepository.create(newStudent(id, firstName, lastName, classLetter, classYear));
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.read(id);
    }

    @Override
    public void updateStudent(Integer id, String firstName, String lastName, String classLetter, Integer classYear) {
        studentRepository.update(newStudent(id, firstName, lastName, classLetter, classYear));
    }

    @Override
    public void removeStudent(Integer id) {
        studentRepository.delete(id);
    }

    Student newStudent(Integer id, String firstName, String lastName, String classLetter, Integer classYear) {
        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setClassLetter(classLetter);
        student.setClassYear(classYear);
        return student;
    }


}
