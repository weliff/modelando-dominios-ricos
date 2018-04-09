package br.com.validation;

import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public abstract class DomainValidation {

    private DataBinder dataBinder;

    private List<FieldError> fieldErrors = new ArrayList<>();

    private List<DomainValidation> validations = Collections.emptyList();

    public DomainValidation() {
        dataBinder = new DataBinder(this);
        dataBinder.setValidator(new SpringValidatorAdapter(Validation.buildDefaultValidatorFactory().getValidator()));
    }

    public boolean isValid() {
        return validate(() -> fieldErrors.isEmpty());
    }

    public boolean isInvalid() {
        return !isValid();
    }

    public void addFieldError(String fieldName, String message) {
        new FieldError(this.getClass().getName(), fieldName, message);
    }

    public void addValidations(DomainValidation... validations) {
        this.validations = asList(validations);
    }

    public List<FieldError> getNotifications() {
        return validate(() -> Collections.unmodifiableList(fieldErrors));
    }

    private <T> T validate(Supplier<T> supplier) {
        validate();
        return supplier.get();
    }

    private void validate() {
        dataBinder.validate();
        List<FieldError> errors = validations.stream()
                .flatMap(domainValidation -> domainValidation.getNotifications().stream())
                .collect(toList());

        this.fieldErrors.addAll(dataBinder.getBindingResult().getFieldErrors());
        this.fieldErrors.addAll(errors);

    }
}
