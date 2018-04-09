package br.com.command;

import br.com.vo.Document;
import br.com.vo.DocumentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreatePayPalSubscriptionCommand implements Command {

    public String email;
    public String transactionCode;
    public LocalDate paidDate;
    public LocalDate expireDate;
    public BigDecimal total;
    public BigDecimal totalPaid;
    public String payer;
    public String payerDocument;
    public DocumentType payerDocumentType;
    public String firstName;
    public String lastName;
    public String document;
    public String street;
    public String number;
    public String neighborhood;
    public String city;
    public String state;
    public String country;
    public String zipCode;

    @Override
    public void validate() {

    }
}
