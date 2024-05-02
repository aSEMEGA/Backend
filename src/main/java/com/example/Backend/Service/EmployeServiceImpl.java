package com.example.Backend.Service;

import com.example.Backend.Dto.EmployeResponse;
import com.example.Backend.Entity.Employe;
import com.example.Backend.Enums.State;
import com.example.Backend.Repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    @Override
    public EmployeResponse save(Employe employe) {
        Employe foundEmploye = employeRepository.save(employe);
        return maToResponse(foundEmploye);
    }

    @Override
    public EmployeResponse findByIdAndEmail(Long id, String email) {
        return null;
    }

    @Override
    public List<EmployeResponse> findByIdAndState(Long id, State state) {
        return null;
    }

    @Override
    public EmployeResponse findByState(State state) {
        return null;
    }

    @Override
    public EmployeResponse update(Employe employe) {
        Employe employe1 = employeRepository.findByIdAndState(employe.getId(), State.Activate);
        if (employe1 == null) {


        }
        employe1.setNom(employe.getNom());
        employe1.setPrenom(employe.getPrenom());
        employe1.setEmail(employe.getEmail());
        employe1.setPassword(employe.getPassword());
        employe1.setAdresse(employe.getAdresse());
        employe1.setTelephone(employe.getTelephone());
        return maToResponse(employe1);
    }

    @Override
    public EmployeResponse delete(Employe employe) {
        Employe employe1 = employeRepository.findByIdAndState(employe.getId(), State.Activate);
        if (employe1 != null) {
            employe1.setState(State.Deactivate);
            employeRepository.save(employe1);

    }
        return maToResponse(employe1);
    }

    @Override
    public List<EmployeResponse> read() {
        List<Employe> employes = employeRepository.findAll();
        List<EmployeResponse> employeResponses = maToResponse(employes);
        for (Employe employe : employes) {
            employeResponses.add(maToResponse(employe));
        }
        return employeResponses;
    }

    EmployeResponse maToResponse(Employe employe) {
        return EmployeResponse.builder()
                .id(employe.getId())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .email(employe.getEmail())
                .password(employe.getPassword())
                .adresse(employe.getAdresse())
                .telephone(employe.getTelephone())
                .state(employe.getState())
                .build();
    }
    List<EmployeResponse> maToResponse(List<Employe> employes) {
        List<EmployeResponse> employeResponses = new ArrayList<>();
        for (Employe employe : employes) {
            employeResponses.add(maToResponse(employe));
        }
        return employeResponses;
    }
}
