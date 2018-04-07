package br.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Email extends ValueObject {

    private String address;

}
