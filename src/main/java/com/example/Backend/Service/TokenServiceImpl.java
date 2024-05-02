package com.example.Backend.Service;

import com.example.Backend.Entity.Employe;
import com.example.Backend.Entity.Token;
import com.example.Backend.Repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    @Override
    public Token save(Employe employe, String token) {

        // Création d'un nouvel objet Token à l'aide du pattern Builder

        Token tokensaved = Token.builder()
                // Attribution du jeton au token
                .token(token)
                // Initialisation de l'attribut revoked à false
                .revoked(false)
                // Initialisation de l'attribut expired à false
                .expired(false)
                // Initialisation de l'attribut createAt à la date et l'heure actuelles
                .createAt(LocalDateTime.now())
                // Attribution de l'employe au token
                .employe(employe)
                // Renvoi du token sauvegardé
                .build();
        // Sauvegarde du token
        return tokenRepository.save(tokensaved);
    }

    @Override
    public void revokedAllEmployeToken(Employe employe) {

        // Récupération de tous les tokens actifs de l'employé
        List<Token> tokens = tokenRepository.findByAllEmployeIdAndExpiredIsFalseAndRevokedIsFalse(employe.getId());
        if (tokens.isEmpty()){
            return;
        }

        // Boucle parcourant tous les tokens de la liste
        tokens.forEach(token -> {
            // Vérification si le token appartient à l'employé spécifié
            if (token.getEmploye().equals(employe)){
                // Mise à jour de l'attribut revoked à true
                token.setRevoked(true);
                // Mise à jour de l'attribut expired à true
                token.setExpired(true);
                // Attribution de la date et de l'heure actuelles à l'attribut logoutAt
                token.setLogoutAt(LocalDateTime.now());
            }
        });
tokenRepository.saveAll(tokens);

    }
}
