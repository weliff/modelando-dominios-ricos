package br.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address extends ValueObject {

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
