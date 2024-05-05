package org.example.studentservice;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

class StudentRepositoryMockTest {
    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    public StudentRepositoryMockTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRepositoryInteraction() {
        service.addStudent(new Student("1", "Test", 20));
        verify(repository).addStudent(any(Student.class));
    }
}