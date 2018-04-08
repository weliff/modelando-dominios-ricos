package br.com.entity.contract.validation;

import br.com.entity.Subscription;
import br.com.entity.contract.OnlyOneSubscriptionActive;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class OnlyOneSubscriptionActiveValidator implements ConstraintValidator<OnlyOneSubscriptionActive, List<Subscription>> {

    @Override
    public void initialize(OnlyOneSubscriptionActive constraintAnnotation) { }

    @Override
    public boolean isValid(List<Subscription> subscriptions, ConstraintValidatorContext constraintValidatorContext) {
            return subscriptions.stream()
                    .filter(Subscription::getActive).count() <= 1;
    }
}
