package io.neko.springsecurityservice.security;

import io.neko.springsecurityservice.security.model.User;
import io.neko.springsecurityservice.security.model.UserPrincipal;
import io.neko.springsecurityservice.security.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {
    private final Users users;

    public InMemoryUserDetailsService(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find username: " + username);
        }
        return new UserPrincipal(user);
    }
}
