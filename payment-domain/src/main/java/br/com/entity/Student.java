package br.com.entity;

import br.com.entity.contract.OnlyOneSubscriptionActive;
import br.com.vo.Address;
import br.com.vo.Document;
import br.com.vo.Email;
import br.com.vo.Name;
import lombok.Getter;
import org.springframework.validation.ValidationUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Student extends Entity {

    private Name name;

    @Valid
    private Document document;

    @Valid
    private Email email;

    /* Endereço de entrega */
    private Address address;

    @OnlyOneSubscriptionActive
    private List<@Valid Subscription> subscriptions;

    public Student(Name name, Document document, Email email) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription) {
        if (isValid()) {
            subscriptions.add(subscription);
        }
    }

    //ninguem de fora pode alterar a lista -- evita corrupção
    public List<Subscription> getSubscriptions() {
        return Collections.unmodifiableList(subscriptions);
    }
}
