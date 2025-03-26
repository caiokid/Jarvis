package br.com.teste.pizza.config;

import br.com.teste.pizza.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class TokenService {

    public String criarToken(Usuario usuario) {
        try{
            Algorithm al = Algorithm.HMAC256("1234");
            LocalDateTime dataExpiracao = LocalDateTime.now().plusHours(2);
            return JWT.create()
                    .withIssuer("DoPai")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00")))
                    .sign(al);

        }catch(JWTCreationException e){
            throw new RuntimeException("Erro ao criar Token",e);
        }
    }


    public String buscarUsuario(String token){
        try{
            Algorithm al = Algorithm.HMAC256("1234");

            return JWT.require(al)
                    .withIssuer("DoPai")
                    .build()
                    .verify(token)
                    .getSubject();


        }catch (JWTVerificationException e){
            throw new RuntimeException("Erro ao buscar Usuario",e);
        }
    }


}
