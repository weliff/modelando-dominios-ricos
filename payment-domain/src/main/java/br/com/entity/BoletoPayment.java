package br.com.entity;

import br.com.vo.Address;
import br.com.vo.Document;
import br.com.vo.Email;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class BoletoPayment extends Payment {

    private String barCode;

    private String boletoNumber;

    public BoletoPayment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                         String payer, Document document, Address address, Email email, String barCode, String boletoNumber) {

        super(paidDate, expireDate, total, totalPaid, payer, document, address, email);
        this.barCode = barCode;
        this.boletoNumber = boletoNumber;
    }
}
