package br.com.config;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class ServiceForTest {

    void validateEmail(@Email String email) {
        System.out.println("email válido: " + email);
    }


}
