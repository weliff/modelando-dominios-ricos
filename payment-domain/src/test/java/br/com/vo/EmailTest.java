package br.com.vo;

import br.com.config.ContractConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

class EmailTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    void shouldValidateEmail() {
        Email email = new Email("weliff@email.com");

        Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);

        Assertions.assertTrue(constraintViolations.isEmpty());
    }
}