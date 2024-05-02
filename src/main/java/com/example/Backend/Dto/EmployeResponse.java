package com.example.Backend.Dto;

import com.example.Backend.Enums.State;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String telephone;
    private State state;
}
