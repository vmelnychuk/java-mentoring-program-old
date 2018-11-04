package io.neko.springsecurityservice.dto;

import java.util.UUID;

public class HelloMessage {
    private final String message;
    private final String id;

    public HelloMessage(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public HelloMessage(String message) {
        this.message = message;
        this.id = UUID.randomUUID().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }
}
