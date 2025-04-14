package com.example.demo.security;

import com.example.demo.exceptions.UserNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        if ("user".equals(username)) {
            return User.withUsername("user")
                    .password(passwordEncoder.encode("abc"))
                    .roles("USER")
                    .build();
        } else if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password(passwordEncoder.encode("adminpwd"))
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UserNotFoundException(username);
        }
    }

}
