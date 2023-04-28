package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Facture;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface FactureService {
    String getNextFactureNum(Date date);
    ResponseEntity<Facture> addFacture(Facture bonHonoraire);
    Facture getFacture(long idFac);
    List<Facture> getAllFactures();
    void deleteFacture(long idFac);
}
