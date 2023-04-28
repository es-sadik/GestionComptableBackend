package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

    @Query(value = "select u from User u JOIN u.role r where r.roleName <> 'Admin' ")
    List<User> selectAllWhitoutAdmin();

    @Query(value = "select u from User u JOIN u.role r where u.id = ?1 and r.roleName <> 'Admin' ")
    User selectOneWhitoutAdmin(long id);

}
