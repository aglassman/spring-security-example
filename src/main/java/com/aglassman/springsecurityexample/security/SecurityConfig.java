package com.aglassman.springsecurityexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Profile("secure")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
		// -- swagger ui
		"/swagger-resources/**",
		"/swagger-ui.html",
		"/v2/api-docs",
		"/webjars/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(AUTH_WHITELIST).authenticated()
			.antMatchers(HttpMethod.GET, "/items/**").authenticated()
			.and()
				.formLogin()
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login");;
	}

	@Bean
	public DaoAuthenticationProvider authProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		//authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authProvider;
	}


}