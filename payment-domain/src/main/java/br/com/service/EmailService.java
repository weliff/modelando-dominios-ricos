package br.com.service;

public interface EmailService {

    void send(String to, String email, String subject, String body);

}
