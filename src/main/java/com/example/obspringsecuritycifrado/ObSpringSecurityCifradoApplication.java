package com.example.obspringsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);
        UserRepository repository = applicationContext.getBean(UserRepository.class);

        PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

        User user = new User(null, "empanadas123", passwordEncoder.encode("123456"));
        repository.save(user);
    }

}
