package br.com.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Getter
public class Subscription {

    private LocalDate createDate;

    private LocalDate lastUpdateDate;

    private LocalDate expireDate;

    private Boolean active;

    private List<Payment> payments;

    public Subscription(LocalDate expireDate) {
        this.createDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
        this.expireDate = expireDate;
        this.active = true;
        this.payments = new ArrayList<>();
    }

    public void activate() {
        active = true;
        lastUpdateDate = LocalDate.now();
    }

    public void inactivate() {
        active = true;
        lastUpdateDate = LocalDate.now();
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public Optional<LocalDate> getExpireDate() {
        return Optional.ofNullable(expireDate);
    }

    public List<Payment> getPayments() {
        return Collections.unmodifiableList(payments);
    }
}
