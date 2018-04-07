package br.com.entity;

import br.com.vo.Document;
import br.com.vo.Name;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Student extends Entity {

    private Name name;

    private Document document;

    private String email;

    /* Endereço de entrega */
    private String address;

    private List<Subscription> subscriptions;

    public Student(Name name, Document document, String email) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.forEach(Subscription::activate);
        subscriptions.add(subscription);
    }

    //ninguem de fora pode alterar a lista
    public List<Subscription> getSubscriptions() {
        return Collections.unmodifiableList(subscriptions);
    }
}
