package br.com.entities;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class PayPalPayment extends Payment {

    private String transactionCode;

    public PayPalPayment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                         String payer, String document, String address, String email, String transactionCode) {
        super(paidDate, expireDate, total, totalPaid, payer, document, address, email);
        this.transactionCode = transactionCode;
    }
}
