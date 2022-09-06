package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class EncryptionTest {
    /*
    * BCrypt  que genera su propio salt de 16 bytes
    *
    * El resultado de cifrar con bcrypt sera un string de 60 caracteres
    *
    * $a version
    * $10 fuerza( valor que va de 4 a 31, por defecto vale 10)
    * Los 22 siguientes caracteres son el salt generado
    */
    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//        for (int i = 0; i < 10; i++) {
            String hashedPassword = passwordEncoder.encode("admin");
            System.out.println(hashedPassword);
//        }
        boolean matches = passwordEncoder.matches("admin", "$2a$10$EQ4NiWeDm58FSXoU8tk61u7YfBi78D5X1xcOWjgVTEKWEANW/CLYi");
        System.out.println(matches);
    }

    @Test
    void bcryptTestCheckMultiplePassword(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            String hashedPassword = passwordEncoder.encode("admin");
            System.out.println(hashedPassword);
        }
    }

    @Test
    void Pbkdf2PasswordEncoderTest(){
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        for (int i = 0; i < 10; i++) {
            String hashedPassword = passwordEncoder.encode("admin");
            System.out.println(hashedPassword);
        }
    }

//    @Test
//    void argonTest(){
//        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
//        for (int i = 0; i < 10; i++) {
//            String hashedPassword = passwordEncoder.encode('admin');
//            System.out.println(hashedPassword);
//        }
//    }

    @Test
    void scriptTest(){
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            String hashedPassword = passwordEncoder.encode("asddd");
            System.out.println(hashedPassword);
        }
    }

}
