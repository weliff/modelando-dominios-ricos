package br.com.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Entity {

    private UUID uuid;

    public Entity() {
        this.uuid = UUID.randomUUID();
    }
}
