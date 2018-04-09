package br.com.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {


//    private Validator validator;
//
//    @BeforeEach
//    void setUp() {
//        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }

    @Test
    void shouldReturnErrorWhenCNPJIsInvalid() {
        Document document = new Document("12345", DocumentType.CNPJ);
        assertTrue(document.isInvalid());
//        Set<ConstraintViolation<document>> constraintViolations = validator.validate(document);
//        assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void shouldReturnErrorWhenCNPJIsValid() {
        Document document = new Document("33387853000187", DocumentType.CNPJ);
        assertTrue(document.isValid());
    }


    @Test
    void shouldReturnErrorWhenCPFIsInvalid() {
        Document document = new Document("12345", DocumentType.CPF);
        assertTrue(document.isInvalid());

    }


    @Test
    void shouldReturnErrorWhenCPFIsValid() {
        Document document = new Document("48751824060", DocumentType.CPF);
        assertTrue(document.isValid());

    }
}