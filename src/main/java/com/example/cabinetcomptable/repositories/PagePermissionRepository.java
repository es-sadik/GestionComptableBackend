package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.PagePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagePermissionRepository extends JpaRepository<PagePermission, Long> {
}