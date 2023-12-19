package io.spring.todoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = getUserDetails("user1", "User1!");
        UserDetails user2 = getUserDetails("user2", "User2!");
        return new InMemoryUserDetailsManager(user1, user2);
    }

    private UserDetails getUserDetails(String userName, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    } 
}
