package com.example.Backend.Dto;

import com.example.Backend.Entity.Role;
import com.example.Backend.Enums.State;

import java.util.List;

public class AuthResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String password;
    private String telephone;
    List<Role> roles;
    private State state;
    private String token;
}
