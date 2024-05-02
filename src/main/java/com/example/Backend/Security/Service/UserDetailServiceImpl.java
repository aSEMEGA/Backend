package com.example.Backend.Security.Service;

import com.example.Backend.Entity.Employe;
import com.example.Backend.Enums.State;
import com.example.Backend.Repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.Backend.Security.Service.UserDetailImpl.build;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final EmployeRepository employeRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employe employe = employeRepository.findByEmailAndState(email, State.Activate);
        if (employe == null) {
            throw new UsernameNotFoundException("Email ou mot de passe incorrect");
        }
        return UserDetailImpl.build(employe);
    }
}
