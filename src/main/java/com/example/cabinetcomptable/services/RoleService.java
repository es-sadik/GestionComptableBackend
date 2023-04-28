package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.repositories.RoleRepository;
import com.example.cabinetcomptable.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
