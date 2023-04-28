package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ReglementFournisseurService {

    String getNextCodeReglementFournisseur(Date date);

    ResponseEntity<ReglementFournisseur> addReglementFournisseur(ReglementFournisseur reglementFournisseur) ;

    List<ReglementFournisseur> addListReglementFournisseur( List<ReglementFournisseur> listReglementFournisseur );
    ResponseEntity<ReglementFournisseur> getReglementFournisseur(long id_reg_c);
    List<ReglementFournisseur> getAllReglementFournisseurs();
    ResponseEntity<ReglementFournisseur> updateReglementFournisseur(long id_reg_c, ReglementFournisseur reglementFournisseur);
    void deleteReglementFournisseur(long id_reg_c);

}
