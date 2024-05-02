package com.example.Backend.Security.Jwt;

import com.example.Backend.Security.Service.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {

    // Message d'erreur à afficher pour l'accès interdit
    private static final String FORBIDDEN_MESSAGE = "Vous devez être connecter pour accéder à cette page";

    // Méthode appelée lorsqu'une exception d'authentification se produit
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Création de l'objet HttpResponse pour le message d'erreur
        HttpResponse httpResponse = new HttpResponse(new Date(), FORBIDDEN.value(), FORBIDDEN,
                FORBIDDEN.getReasonPhrase().toUpperCase(), FORBIDDEN_MESSAGE);

        // Configuration de l'en-tête de la réponse
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(FORBIDDEN.value());

        // Récupération du flux de sortie pour écrire la réponse
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();

        // Écriture de l'objet HttpResponse sous forme JSON dans le flux de sortie
        mapper.writeValue(outputStream, httpResponse);

        // Vidage du flux de sortie
        outputStream.flush();
    }
}
