package br.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Name extends ValueObject {

    private String firstName;

    private String lastName;

}

