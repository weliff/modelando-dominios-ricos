package br.com.entity;

import br.com.vo.Address;
import br.com.vo.Document;
import br.com.vo.Email;
import lombok.Getter;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@ScriptAssert(lang = "javascript", script = "_this.total.compareTo(_this.totalPaid) <= 0")
@Getter
public abstract class Payment extends Entity {

    private String number;

    @PastOrPresent
    private LocalDate paidDate;

    @FutureOrPresent
    private LocalDate expireDate;

    @Min(1)
    private BigDecimal total;


    private BigDecimal totalPaid;

    private String payer;

    @Valid
    private Document document;

    /* Endereço de cobrança  */
    private Address address;

    /* o aluno pode ter emails diferentes pr pagamento. ex: paypal */
    private Email email;

    public Payment(LocalDate paidDate, LocalDate expireDate, BigDecimal total, BigDecimal totalPaid,
                   String payer, Document document, Address address, Email email) {

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
