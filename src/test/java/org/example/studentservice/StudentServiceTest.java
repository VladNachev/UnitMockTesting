package org.example.studentservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    private StudentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new StudentService(repository);
    }

    @Test
    void testStudentLifecycle() {
        // Step 1: Add a student
        Student newStudent = new Student("3", "Charlie", 24);
        doNothing().when(repository).addStudent(newStudent);
        service.addStudent(newStudent);
        verify(repository).addStudent(newStudent);

        // Step 2: Retrieve students to confirm addition
        when(repository.getStudents()).thenReturn(Collections.singletonList(newStudent));
        List<Student> students = service.getStudents();
        assertTrue(students.contains(newStudent));

        // Step 3: Update the student
        Student updatedStudent = new Student("3", "Charlie", 25);
        doNothing().when(repository).updateStudent(updatedStudent);
        service.updateStudent(updatedStudent);
        verify(repository).updateStudent(updatedStudent);

        // Step 4: Delete the student
        doNothing().when(repository).deleteStudent(newStudent.getId());
        service.deleteStudent(newStudent.getId());
        verify(repository).deleteStudent(newStudent.getId());
    }

}