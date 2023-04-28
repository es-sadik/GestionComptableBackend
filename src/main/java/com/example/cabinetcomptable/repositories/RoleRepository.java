package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRoleName(String user);

}
