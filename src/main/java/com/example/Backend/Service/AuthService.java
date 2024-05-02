package com.example.Backend.Service;

import com.example.Backend.Dto.AuthRequest;
import com.example.Backend.Dto.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
}
