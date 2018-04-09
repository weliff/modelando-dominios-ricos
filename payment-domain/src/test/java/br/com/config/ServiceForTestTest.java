package br.com.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceForTestTest {


    private AnnotationConfigApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ContractConfig.class);

    }

    @Test
    void validateEmail() {
        ServiceForTest serviceForTest = applicationContext.getBean(ServiceForTest.class);
        Assertions.assertThrows(ConstraintViolationException.class, () -> serviceForTest.validateEmail("invalid"));
    }
}