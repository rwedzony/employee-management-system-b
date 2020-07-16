package com.rafwedz.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails> users =new ArrayList<>();
        users.add(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build()
        );
        users.add(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user")
                        .roles("USER")
                        .build()
        );
        users.add(
                User.withDefaultPasswordEncoder()
                        .username("moderator")
                        .password("moderator")
                        .roles("MODERATOR")
                        .build()
        );



        return new InMemoryUserDetailsManager(users);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**").hasAnyRole("USER","MODERATOR","ADMIN")
                .antMatchers(HttpMethod.POST,"/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/employees", true)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

    }
}




