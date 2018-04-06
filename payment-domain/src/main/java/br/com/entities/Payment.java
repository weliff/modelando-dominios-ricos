package br.com.entities;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public abstract class Payment {

    private String number;

    private LocalDate paidDate;

    private LocalDate expireDate;

    private BigDecimal total;

    private BigDecimal totalPaid;

    private String payer;

    private String document;

    /* Endereço de cobrança  */
    private String address;

    /* o aluno pode ter emails diferentes pr pagamento. ex: paypal */
    private String email;

    public Payment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                   String payer, String document, String address, String email) {
        this.number = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
        this.paidDate = paidDate;
        this.expireDate = expireDate;
        this.total = total;
        this.totalPaid = totalPaid;
        this.payer = payer;
        this.document = document;
        this.address = address;
        this.email = email;
    }
}
