package br.com.entity;

import br.com.vo.Address;
import br.com.vo.Document;
import br.com.vo.Email;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class PayPalPayment extends Payment {

    private String transactionCode;

    public PayPalPayment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                         String payer, Document document, Address address, Email email, String transactionCode) {

        super(paidDate, expireDate, total, totalPaid, payer, document, address, email);
        this.transactionCode = transactionCode;
    }
}
