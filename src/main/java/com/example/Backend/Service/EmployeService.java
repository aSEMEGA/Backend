package com.example.Backend.Service;

import com.example.Backend.Dto.EmployeResponse;
import com.example.Backend.Entity.Employe;
import com.example.Backend.Enums.State;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeService {

    EmployeResponse save(Employe employe);


    EmployeResponse findByIdAndEmail(Long id, String email);

    List<EmployeResponse> findByIdAndState(Long id, State state);
    EmployeResponse findByState(State state);

    EmployeResponse update(Employe employe);
    EmployeResponse delete(Employe employe);

    List<EmployeResponse> read();

}
