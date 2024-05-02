package com.example.Backend.Entity;

import com.example.Backend.Enums.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private State state = State.Activate;
    @ManyToMany
    private List<Employe> employes = new ArrayList<>();

    public Role(String nom) {
        this.nom = nom;
    }
}
