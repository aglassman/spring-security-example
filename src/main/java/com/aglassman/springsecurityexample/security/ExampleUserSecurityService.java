package com.aglassman.springsecurityexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ExampleUserSecurityService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomUser customUser = userRepository.findByUsername(username);

        if(customUser == null) {
            throw new AccessDeniedException("Forbidden");
        }

        return customUser;
    }
}
