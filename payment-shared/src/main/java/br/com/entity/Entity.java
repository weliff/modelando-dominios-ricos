package br.com.entity;

import br.com.validation.DomainValidation;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Entity extends DomainValidation {

    private UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

}
