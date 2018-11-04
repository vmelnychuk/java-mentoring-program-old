package io.neko.springsecurityservice.security;

import io.neko.springsecurityservice.security.model.Users;
import io.neko.springsecurityservice.security.utils.UsersReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentsConfiguration {
    @Bean
    public Users users() {
        return new UsersReader("/users.yml").readUsers();
    }
}
