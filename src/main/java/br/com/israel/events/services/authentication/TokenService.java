package br.com.israel.events.services.authentication;

import br.com.israel.events.domain.User;
import br.com.israel.events.exceptions.BadRequestException;
import br.com.israel.events.exceptions.ForbiddenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api:security:token:secret}")
    private String secret;

    public String gerarToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Events")
                    .withSubject(user.getEmail())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new BadRequestException("Error generating JWT token: " + exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Events")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new ForbiddenException("Invalid or expired token!");
        }
    }

    public User getLoggedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusSeconds(3600).toInstant(ZoneOffset.of("-03:00"));
    }
}
