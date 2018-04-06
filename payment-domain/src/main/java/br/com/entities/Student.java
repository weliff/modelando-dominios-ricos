package br.com.entities;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class Student {

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    /* Endereço de entrega */
    private String address;

    private List<Subscription> subscriptions;

    public Student(String firstName, String lastName, String document, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
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
