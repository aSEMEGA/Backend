package com.example.Backend.Service;

import com.example.Backend.Entity.Employe;
import com.example.Backend.Entity.Token;

public interface TokenService {

    Token save(Employe employe, String token);

    void revokedAllEmployeToken(Employe employe);
}
