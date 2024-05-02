package com.example.Backend.Entity;

import com.example.Backend.Enums.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private State state = State.Activate;

    @ManyToMany(fetch = FetchType.EAGER)
   private List<Role> roles = new ArrayList<>();
}
