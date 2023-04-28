package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.PagePermission;
import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.repositories.PagePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagePermissionService {
    @Autowired
    private PagePermissionRepository pagePermissionRepository;

    public PagePermission createNewPagePermission(PagePermission pagePermission) {
        return pagePermissionRepository.save(pagePermission);
    }

    public List<PagePermission> getAllPagePermissions() {
        return pagePermissionRepository.findAll();
    }
}
