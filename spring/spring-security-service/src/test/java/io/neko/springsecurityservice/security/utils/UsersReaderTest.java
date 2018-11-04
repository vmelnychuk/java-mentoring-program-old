package io.neko.springsecurityservice.security.utils;

import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.Assert.*;

public class UsersReaderTest {
    @Test
    public void readUsersFile() {
        UserDetails userDetails = User.withUsername("user").password("user").roles("user").build();

        List<UserDetails> users = new UsersReader("/users.yml").readUsers();

        assertTrue(users.contains(userDetails));
    }

}
