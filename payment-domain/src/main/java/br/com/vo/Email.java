package br.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@AllArgsConstructor
public class Email extends ValueObject {

    @org.hibernate.validator.constraints.Email
    private String address;

}
