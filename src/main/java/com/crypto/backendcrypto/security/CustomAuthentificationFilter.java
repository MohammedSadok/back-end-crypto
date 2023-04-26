package com.crypto.backendcrypto.security;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin
public class CustomAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public CustomAuthentificationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = request.getParameter("email").toString();
        String password = request.getParameter("password");
        log.info("email : {}",email);
        log.info("password : {}",password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        log.info(user.toString());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

        String acces_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 10 * 6000 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        log.info(acces_token.toString());

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 45 * 6000 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        log.info(refresh_token.toString());

        /*response.setHeader("user", String.valueOf(user.getAuthorities()));
        response.setHeader("acces_token",acces_token);
        response.setHeader("refresh_token",refresh_token);*/

        Map<String,String> tokens = new HashMap<>();
        tokens.put("acces_token",acces_token);
        tokens.put("refresh_token",refresh_token);
        tokens.put("email",user.getUsername());

        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),tokens);

        log.info("tokens generated");
    }
}
