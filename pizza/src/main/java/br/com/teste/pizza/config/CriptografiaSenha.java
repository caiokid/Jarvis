package br.com.teste.pizza.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografiaSenha {

    private static final BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();

    public static String criptografia(String senha){
        return enconder.encode(senha);
    }
}
