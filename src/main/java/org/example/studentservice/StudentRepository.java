package org.example.studentservice;

import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();
    void addStudent(Student student);
    void deleteStudent(String id);
    void updateStudent(Student student);
}