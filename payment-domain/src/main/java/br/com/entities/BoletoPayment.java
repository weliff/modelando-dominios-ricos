package br.com.entities;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class BoletoPayment extends Payment {

    private String barCode;

    private String boletoNumber;

    public BoletoPayment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                         String payer, String document, String address, String email, String barCode, String boletoNumber) {
        super(paidDate, expireDate, total, totalPaid, payer, document, address, email);
        this.barCode = barCode;
        this.boletoNumber = boletoNumber;
    }
}
