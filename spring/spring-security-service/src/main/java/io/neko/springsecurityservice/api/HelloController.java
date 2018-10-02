package io.neko.springsecurityservice.api;

import io.neko.springsecurityservice.dto.HelloMessage;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HelloMessage hello(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return new HelloMessage(name);
    }

    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HelloMessage helloAdmin(@RequestParam(value = "name", defaultValue = "Admin") String name) {
        return new HelloMessage(name);
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public HelloMessage helloUser(@RequestParam(value = "name", defaultValue = "User") String name) {
        return new HelloMessage(name);
    }
}
