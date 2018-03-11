package com.aglassman.springsecurityexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

import static com.aglassman.springsecurityexample.security.CustomAuthorities.EMPLOYEE;
import static com.aglassman.springsecurityexample.security.CustomAuthorities.PREFERRED_VENDOR;
import static com.aglassman.springsecurityexample.security.CustomAuthorities.VENDOR;

@Component
public class ExampleUserSecurityService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomUser customUser = userRepository.findByUsername(username);

        LinkedList<GrantedAuthority> authorities = new LinkedList();

        if(customUser.isEmployee) {
            authorities.add(EMPLOYEE);
        }

        if(customUser.isVendor) {
            authorities.add(VENDOR);
        }

        if(customUser.isPreferred) {
            authorities.add(PREFERRED_VENDOR);
        }

        User user = new User(
                customUser.getUsername(),
                customUser.getPassword(),
                authorities);

        return user;
    }
}
