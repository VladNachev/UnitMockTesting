package org.example.studentservice;

import java.util.List;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.getStudents();
    }

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public void deleteStudent(String id) {
        repository.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        repository.updateStudent(student);
    }
}