package com.exercise.cakemanager.cakemanagerapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CakeSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails manager = User.builder()
                .username("manager")
                .password("{bcrypt}$2a$10$Eqa4/JrOeM53EopoA.lHj.uLBDxLoSMuyNS9pTeuqeocv7DQqH0/e")
                .roles("MANAGER", "USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$.qqqKovzwIZ120KJcIVDhODRs7rgQ0sdOvSE1NVJSdawvBF4Cus3a")
                .roles("ADMIN", "USER")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$cZBOZmPwXjIGg.Fv6..PU.golRpAMHbsx7TRM1Uy.g3KbFU39P/DK")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(manager, admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/cakes").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/cakes").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/cakes").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/cakes/**").hasRole("ADMIN")
                );
        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
