package br.com.entity.contract;

import br.com.entity.contract.validation.OnlyOneSubscriptionActiveValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = OnlyOneSubscriptionActiveValidator.class)
public @interface OnlyOneSubscriptionActive {

    String message() default "Somente uma assinatura ativa é permitida";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
