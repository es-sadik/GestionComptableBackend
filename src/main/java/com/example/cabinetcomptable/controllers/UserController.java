package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@PreAuthorize("hasRole('Admin')")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @GetMapping("/ifExist/{userName}")
    public ResponseEntity<Boolean> checkUserName(@PathVariable String userName){
        return ResponseEntity.ok(userService.checkUserNameIfExist(userName));
    }

    @PostMapping({"/add"})
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/getAll")
    public ResponseEntity< List<User> > getAllUsers(){
        return ResponseEntity.ok( userService.getAllUsers() );
    }
    @GetMapping("/getAllNoAdmin")
    public ResponseEntity< List<User> > getAllUserNoAdmin(){
        return ResponseEntity.ok( userService.getAllUserWithoutAdmin());
    }

    @GetMapping("/getOneNoAdmin/{id}")
    public ResponseEntity<User> getOneUserNoAdmin(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserWithoutAdmin(id));
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/getOneByUserName/{userName}")
    public ResponseEntity<User> getOneByUserName(@PathVariable String userName){
        return ResponseEntity.ok(userService.getByUserName(userName));
    }
    @GetMapping("/getAdmin/{id}")
    public ResponseEntity<User> getAdmin(@PathVariable long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        return  ResponseEntity.ok(userService.updateUser(id,user));
    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<User> updateAdmin(@PathVariable long id, @RequestBody User user) {
        return  ResponseEntity.ok(userService.updateAdmin(id,user));
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable long id){
       userService.deleteUser(id);
    }

}
