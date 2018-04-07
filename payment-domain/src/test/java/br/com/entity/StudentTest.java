package br.com.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class StudentTest {

//    private Student student;
//
//    @BeforeEach
//    void setUp() {
//        this.student = new Student();
//    }

    @Test
    void adicionarAssinatura() {

        Subscription subscription = new Subscription(LocalDate.now().plusDays(30));

        Student student = new Student("Weliff",
                "Lima", "11111111", "weliff@email.com");

        student.addSubscription(subscription);
    }
}