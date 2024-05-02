package com.example.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    private boolean revoked;
    private boolean expired;

    private LocalDateTime createAt;

    private LocalDateTime logoutAt;

   @ManyToOne(fetch = FetchType.LAZY)
    private Employe employe;


}
