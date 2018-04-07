package br.com.entity;

import br.com.config.ContractConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

class StudentTest {

//    private Student student;
//
    @BeforeEach
    void setUp() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ContractConfig.class);
    }

    @Test
    void adicionarAssinatura() {

        Subscription subscription = new Subscription(LocalDate.now().plusDays(30));

//        Student student = new Student("Weliff",
//                "Lima", "11111111", "weliff@email.com");

//        student.addSubscription(subscription);
    }
}