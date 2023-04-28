package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.LignBH;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LignBHService {

    ResponseEntity<LignBH> addLignBH(LignBH lignBH);

    List<LignBH> addListLignBH(List<LignBH> listLignBH);

    ResponseEntity<LignBH> getLignBH(long id_lign_a);
    List<LignBH> getAllLignBHs();
    ResponseEntity<LignBH> updateLignBH(LignBH lignBH , long id_lign_a);
    void deleteLignBH(long id_lign_a);
}
