package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.LignBA;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface LignBAService {

    ResponseEntity<LignBA> addLignBA(LignBA lignBA);

    List<LignBA> addListLignBA(List<LignBA> listLignBA);

    ResponseEntity<LignBA> getLignBA(long id_lign_a);
    List<LignBA> getAllLignBAs();
    ResponseEntity<LignBA> updateLignBA(LignBA lignBA , long id_lign_a);
    void deleteLignBA(long id_lign_a);

}
