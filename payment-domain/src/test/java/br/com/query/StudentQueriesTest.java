package br.com.query;

import br.com.entity.Student;
import br.com.vo.Document;
import br.com.vo.DocumentType;
import br.com.vo.Email;
import br.com.vo.Name;
import lombok.experimental.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StudentQueriesTest {
    
    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            students.add(new Student(
                    new Name("Aluno", i + ""),
                    new Document("1111111111" + i, DocumentType.CPF),
                    new Email(i + "@balta.io")
            ));
        }
    }

    @Test
    void shouldReturnStudentWhenDocumentExists() {
        Student student = students.stream()
                .filter(StudentQueries.getStudentInfo("11111111111"))
                .findAny()
                .orElse(null);

        Assertions.assertNotNull(student);
    }

    @Test
    void shouldReturnNullWhenDocumentExists() {
        Student student = students.stream()
                .filter(StudentQueries.getStudentInfo("12345"))
                .findAny()
                .orElse(null);

        Assertions.assertNull(student);
    }
}