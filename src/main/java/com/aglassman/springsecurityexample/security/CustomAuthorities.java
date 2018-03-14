// File: CustomAuthorities.java
package com.aglassman.springsecurityexample.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthorities {
    // tag::customAuthorities[]
    public static final GrantedAuthority EMPLOYEE = new SimpleGrantedAuthority("EMPLOYEE");
    public static final GrantedAuthority VENDOR = new SimpleGrantedAuthority("VENDOR");
    public static final GrantedAuthority PREFERRED_VENDOR = new SimpleGrantedAuthority("PREFERRED_VENDOR");
    // end::customAuthorities[]
}
