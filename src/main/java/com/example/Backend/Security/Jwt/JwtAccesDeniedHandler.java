package com.example.Backend.Security.Jwt;

import com.example.Backend.Security.Service.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.OutputStream;
import java.io.IOException;
import java.util.Date;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class JwtAccesDeniedHandler implements AccessDeniedHandler {


    private static final String FORBIDDEN_MESSAGE = "Vous n'avez pas les droits pour accéder à cette page";

    // Méthode appelée lorsqu'un accès est refusé en raison de droits insuffisants
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Création de l'objet HttpResponse pour le message d'erreur
        HttpResponse httpResponse = new HttpResponse(new Date(), UNAUTHORIZED.value(), UNAUTHORIZED,
                UNAUTHORIZED.getReasonPhrase().toUpperCase(), FORBIDDEN_MESSAGE);

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
