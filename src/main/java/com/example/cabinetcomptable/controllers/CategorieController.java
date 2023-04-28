package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Categorie;
import com.example.cabinetcomptable.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CategorieController {

    @Autowired
    CategorieService categorieService ;

    // add categorie :
    @PostMapping("categories")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie){
        return ResponseEntity.ok(categorieService.addCategorie(categorie));
    }
    // get categorie :
    @GetMapping("categories/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable long id){
        return categorieService.getCategorie(id);
    }
    // get All categories :
    @GetMapping("categories")
    public List<Categorie> getAllCategories(){
        return categorieService.getAllCategories();
    }
    // update categorie :
    @PutMapping("categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable long id, @RequestBody Categorie categorie ){
        return ResponseEntity.ok(categorieService.updateCategorie(categorie,id));
    }
    // delete categorie :
    @DeleteMapping("categories/{id}")
    public boolean  deleteCategorie(@PathVariable long id){
        return categorieService.deleteCategorie(id);
    }
}
