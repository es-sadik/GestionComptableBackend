package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.*;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.PagePermissionRepository;
import com.example.cabinetcomptable.repositories.RoleRepository;
import com.example.cabinetcomptable.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PagePermissionRepository pagePermissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static User currentUser  =null;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        adminRole = roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setId(2);
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        Set<PagePermission> ListPagePermissions = new HashSet<>();
        String[] permissions = {"Dashboard","Client","Fournisseur","Produit", "BonAchat", "BonHonoraire","ReglementFournisseur","ReglementClient","Facture"};

        for(int i=0;i<permissions.length;i++){
            PagePermission pagePermission = new PagePermission();
            pagePermission.setId(i+1);

            pagePermission.setNamePermission(permissions[i]);
            ListPagePermissions.add(pagePermission);
            pagePermissionRepository.save(pagePermission);
            ListPagePermissions.add(pagePermission);
        }










        User adminUser = new User();
        adminUser.setId(1);
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("123456"));
        adminUser.setEtat(true);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setPagePermissions( ListPagePermissions );
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        /// user

        /*User user = new User();
        user.setUserName("marwane");
        user.setUserPassword(getEncodedPassword("1234"));
        user.setEtat(false);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);


        Set<PagePermission> pagePermissions = new HashSet<>();
        PagePermission pagePermission = new PagePermission();
        pagePermission.setNamePermission("Dashboard");
        pagePermissions.add(pagePermission);

        user.setPagePermissions(pagePermissions);
        user.setRole(userRoles);
        userRepository.save(user);*/
    }

    public boolean checkUserNameIfExist(String userName) {
        if(userRepository.findByUserName(userName) != null ){
            return true;
        }
        else{
            return  false;
        }


    }

    public User addUser(User user) {
        Role role = roleRepository.findByRoleName("User");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepository.save(user);
    }
    
    
    
    public User getUser(long id) {

        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        return currentUser;
    }

    public User getByUserName(String userName) {

        currentUser = userRepository.findByUserName(userName);

        return currentUser;
    }

    public User getUserWithoutAdmin(long id) {

        currentUser = userRepository.selectOneWhitoutAdmin(id);
        return currentUser;
    }

    
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    public List<User> getAllUserWithoutAdmin() {
        return  userRepository.selectAllWhitoutAdmin();
    }

    
    public User updateUser(long id, User user ) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        user.setId(id);
        user.setRole(currentUser.getRole());
        if(user.getUserPassword() != null){
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        }
        else{
            user.setUserPassword(currentUser.getUserPassword());
        }

        currentUser = userRepository.save(user);
        return currentUser;
    }

    public User updateAdmin(long id, User user ) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        user.setId(id);
        user.setRole(currentUser.getRole());
        user.setEtat(true);
        System.out.println( "etat : "+ user.getEtat());
        user.setPagePermissions(currentUser.getPagePermissions());
        if(user.getUserPassword() != null){
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        }
        else{
            user.setUserPassword(currentUser.getUserPassword());
        }

        currentUser = userRepository.save(user);
        return currentUser;
    }


    
    public void deleteUser(long id) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.deleteById(id);
    }
     
    

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


}
