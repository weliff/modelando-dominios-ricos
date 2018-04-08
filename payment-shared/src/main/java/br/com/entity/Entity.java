package br.com.entity;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

@Getter
public abstract class Entity {

    private UUID id;

    @Getter(AccessLevel.PRIVATE)
    protected Validator validator;

    public Entity() {
        this.id = UUID.randomUUID();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    public boolean isValid() {
        Set<ConstraintViolation<Entity>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public boolean isInvalid(){
        return !isValid();
    }
}
