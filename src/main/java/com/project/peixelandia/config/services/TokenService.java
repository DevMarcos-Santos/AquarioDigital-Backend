package com.project.peixelandia.config.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project.peixelandia.domain.entities.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")

    private String secret;

    public String generateToken(Users users) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth")
                    .withSubject(users.getEmail())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("JWT generation failed", exception);
        }
    }

    public String verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
           return "";
        }

    }
}
