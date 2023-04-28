package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.PagePermission;

import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.services.PagePermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/permission")
@PreAuthorize("hasRole('Admin')")
public class PagePermissionController {

    @Autowired
    private PagePermissionService pagePermissionService;

    @PostMapping({"/createNewPagePermission"})
    public PagePermission createNewPagePermission(@RequestBody PagePermission pagePermission) {
        return pagePermissionService.createNewPagePermission(pagePermission);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PagePermission>> getAllPagePermissions(){
        return ResponseEntity.ok( pagePermissionService.getAllPagePermissions() );
    }

}
