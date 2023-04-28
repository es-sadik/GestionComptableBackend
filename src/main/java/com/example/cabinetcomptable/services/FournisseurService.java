package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Fournisseur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FournisseurService {

    ResponseEntity<Fournisseur> addFournisseur(Fournisseur fournisseur);
    ResponseEntity<Fournisseur> getFournisseur(long id);
    List<Fournisseur> getAllFournisseurs();
    ResponseEntity<Fournisseur> updateFournisseur(Fournisseur fournisseur ,long id);
    String getFile();
    void addFile(MultipartFile file);
    boolean deleteFournisseur(long id);

    //
    Fournisseur getFournisseurWithListBonAchat(long id);
}
