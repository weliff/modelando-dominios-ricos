package br.com.repository;

import br.com.entity.Student;

public interface StudentRepository {

    boolean documentExists(String document);

    boolean emailExists(String email);

    void createSubscription(Student student);

}
