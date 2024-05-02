package com.example.Backend.Repository;

import com.example.Backend.Dto.EmployeResponse;
import com.example.Backend.Entity.Employe;
import com.example.Backend.Enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {


    EmployeResponse findByEmail(String email);

    EmployeResponse findByIdAndEmail(Long id, String email);
    Employe findByIdAndState(Long id, State state);

    Employe findByEmailAndState(String email, State state);
}
