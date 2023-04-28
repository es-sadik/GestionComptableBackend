package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Categorie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategorieService {
    Categorie addCategorie(Categorie categorie);
    ResponseEntity<Categorie> getCategorie(long id);
    List<Categorie> getAllCategories();
    Categorie updateCategorie(Categorie categorie ,long id);
    boolean deleteCategorie(long id);

}
