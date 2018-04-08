package br.com.entity;

import br.com.vo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    private Document document;

    private Address address;

    private Email email;

    private Subscription subscription;

    private Student student;

    @BeforeEach
    void setUp() {
        Name name = new Name("Jose", "Lima");
        this.document = new Document("48751824060", DocumentType.CPF);
        this.email = new Email("jose@email.com");
        this.address = new Address("Rua A", "1234", "Bairro B", "São Paulo",
                "SP", "BR", "14300000");

        this.subscription = new Subscription(null);
        this.student = new Student(name, document, email);

    }

    @Test
    void shouldReturnErrorWhenHadActiveSubscription() {
        Payment payment = new PayPalPayment(LocalDate.now(), LocalDate.now().plusDays(5), new BigDecimal(10),
                new BigDecimal(10), "JOSE LIMA", document, address, email, "12345566");
        subscription.addPayment(payment);

        student.addSubscription(subscription);
        student.addSubscription(subscription);

        assertTrue(student.isInvalid());
    }

    @Test
    void shouldReturnErrorWhenSubscriptionHasNoPayment() {
        student.addSubscription(subscription);
        assertTrue(student.isInvalid());
    }

    @Test
    void shouldReturnSuccessWhenAddSubscription() {
        Payment payment = new PayPalPayment(LocalDate.now(), LocalDate.now().plusDays(5), new BigDecimal(10),
                new BigDecimal(10), "JOSE LIMA", document, address, email, "12345566");
        subscription.addPayment(payment);

        student.addSubscription(subscription);

        assertTrue(student.isValid());
    }
}