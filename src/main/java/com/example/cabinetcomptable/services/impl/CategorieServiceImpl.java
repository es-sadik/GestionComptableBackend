package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Categorie;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.CategorieRepository;
import com.example.cabinetcomptable.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    CategorieRepository categorieRepository ;

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public ResponseEntity<Categorie> getCategorie(long id) {
        Categorie categorie =categorieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categorie not exit with id :"+id));
        return ResponseEntity.ok(categorie);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie updateCategorie(Categorie categorie, long id) {
        categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + id));
        categorie.setIdCat(id);
        return categorieRepository.save(categorie);
    }

    @Override
    public boolean deleteCategorie(long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + id));
        if(categorie.getListProduit().isEmpty()){
            categorieRepository.deleteById(id);
            return true;
        }

        return false;

    }
}
