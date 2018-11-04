package io.neko.springsecurityservice.security.filter;

import io.neko.springsecurityservice.security.TokenService;
import io.neko.springsecurityservice.security.InMemoryUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String HEADER_NAME = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private final TokenService tokenService;
    private final InMemoryUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(TokenService tokenService,
                                   InMemoryUserDetailsService userDetailsService) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HEADER_NAME);

        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            String token = header.replaceFirst(TOKEN_PREFIX, "");
            String username = tokenService.getUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
