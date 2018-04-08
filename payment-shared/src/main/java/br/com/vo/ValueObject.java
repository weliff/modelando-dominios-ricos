package br.com.vo;

import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public abstract class ValueObject {

    private Validator validator;

    public ValueObject() {
//        this.validator = new SpringValidatorAdapter(Validation.buildDefaultValidatorFactory().getValidator());
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public boolean isValid() {
        Set<ConstraintViolation<ValueObject>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public boolean isInvalid(){
        return !isValid();

//        DataBinder binder = new DataBinder(this);
//        binder.addValidators(validator);
//        binder.validate();
//        return binder.getBindingResult().hasFieldErrors();
    }

//    public Object getErrors() {
//        DataBinder binder = new DataBinder(this);
//        binder.addValidators(validator);
//        binder.validate();
//        return binder.getBindingResult().hasFieldErrors();
//    }


}
