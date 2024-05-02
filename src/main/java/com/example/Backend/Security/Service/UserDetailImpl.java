package com.example.Backend.Security.Service;

import com.example.Backend.Entity.Employe;
import com.example.Backend.Enums.State;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailImpl implements UserDetails {
    // Identifiant de l'utilisateur
    private Long id;
    // Nom de l'utilisateur
    private String nom;
    // Prénom de l'utilisateur
    private String prenom;
    // Adresse de l'utilisateur
    private String adresse;
    // Email de l'utilisateur
    private String email;
    // Mot de passe de l'utilisateur
    private String password;
    // État de l'utilisateur (activé, désactivé, etc.)
    private State state;
    // Rôles de l'utilisateur
    private Collection<?extends GrantedAuthority> authorities;

    // Constructeur avec tous les attributs
    public UserDetailImpl(Long id, String nom, String prenom, String adresse, String email, String password, State state, Collection<?extends GrantedAuthority> authorities){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.state = state;
        this.authorities = authorities;
    }

    // Méthode statique pour construire un UserDetailsImpl à partir d'un objet Employe
    public static UserDetailImpl build(Employe employe){
        // Convertit les rôles de l'employé en objets GrantedAuthority
        List<GrantedAuthority> roles = employe.getRoles().stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getNom()))
                .collect(Collectors.toList());

        // Crée et retourne un nouvel objet UserDetailsImpl avec les détails de l'employé
        return new UserDetailImpl(
                employe.getId(),
                employe.getNom(),
                employe.getPrenom(),
                employe.getAdresse(),
                employe.getEmail(),
                employe.getPassword(),
                employe.getState(),
                roles
        );
    }

    // Méthode statique pour construire un UserDetailsImpl avec des paramètres donnés
    public static UserDetailImpl build(Long id, String nom, String prenom,String adresse, String email,
                                        String password, State state,
                                        Collection<? extends GrantedAuthority> roles) {
        // Crée et retourne un nouvel objet UserDetailsImpl avec les paramètres donnés
        return new UserDetailImpl(id, nom, prenom, adresse, email,
                password, state, roles);
    }

    // Renvoie le nom d'utilisateur (email)
    @Override
    public String getUsername() {
        return email;
    }

    // Renvoie le mot de passe de l'utilisateur
    @Override
    public String getPassword() {
        return password;
    }

    // Indique si le compte de l'utilisateur a expiré (toujours faux dans ce cas)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Indique si le compte de l'utilisateur est verrouillé (toujours faux dans ce cas)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Indique si les informations d'identification de l'utilisateur ont expiré (toujours faux dans ce cas)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Indique si le compte de l'utilisateur est activé (toujours vrai dans ce cas)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
