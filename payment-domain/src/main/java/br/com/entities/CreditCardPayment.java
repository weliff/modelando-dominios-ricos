package br.com.entities;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class CreditCardPayment extends Payment {

    private String cardHolderName;

    private String cardNumber;

    private String lastTransactionNumber;

    public CreditCardPayment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                             String payer, String document, String address, String email, String cardHolderName,
                             String cardNumber, String lastTransactionNumber) {
        super(paidDate, expireDate, total, totalPaid, payer, document, address, email);
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.lastTransactionNumber = lastTransactionNumber;
    }
}
