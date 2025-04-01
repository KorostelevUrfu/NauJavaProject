package ru.KorostelevIvan.NauJava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.KorostelevIvan.NauJava.entity.Student;

import java.util.List;

@Component
public class StudentRepository implements CrudRepository<Student, Integer> {

    private final List<Student> studentContainer;

    @Autowired
    public StudentRepository(List<Student> studentContainer) {
        this.studentContainer = studentContainer;
    }

    @Override
    public void create(Student student) {
        studentContainer.add(student);
    }

    @Override
    public Student read(Integer id) {
        return studentContainer.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Student student) {
        Student existing = read(student.getId());
        if (existing != null) {
            existing.setFirstName(student.getFirstName());
            existing.setLastName(student.getLastName());
            existing.setClassLetter(student.getClassLetter());
            existing.setClassYear(student.getClassYear());
        }
    }

    @Override
    public void delete(Integer id) {
        studentContainer.removeIf(s -> s.getId().equals(id));
    }
}
