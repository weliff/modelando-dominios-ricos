package br.com.query;

import br.com.entity.Student;

import java.util.Objects;
import java.util.function.Predicate;

public class StudentQueries {

    public static Predicate<Student> getStudentInfo(String document) {
        return student -> Objects.equals(student.getDocument().getNumber(), document);
    }
}
