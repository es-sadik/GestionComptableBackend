package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    ServletContext context;
    // add produit :
    @PostMapping("/produits")
    public ResponseEntity<?> addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    // get Produit :
    @GetMapping("/produits/{reference}")
    public ResponseEntity<Produit> getProduit(@PathVariable String reference){
        return produitService.getProduit(reference);
    }

    // get All Produit :
    @GetMapping("/produits")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    // list produits
    @GetMapping("/produits/OrderBy")
    public List<Produit> selectProduitsOrderByCategorie(){
        return produitService.selectProduitsOrderByCategorie();
    }

    // update Produit :
    @PutMapping("/produits/{reference}")
    public  ResponseEntity<Produit> updateProduit(@RequestBody Produit produit , @PathVariable String reference){
        return  produitService.updateProduit(produit , reference);
    }

    // delete Produit :
    @DeleteMapping("/produits/{reference}")
    public  boolean deleteProduit(@PathVariable String reference){
        return produitService.deleteProduit(reference);
    }
    @GetMapping("/imageproduit")
    public ResponseEntity<String> getImage(){
        return ResponseEntity.ok(produitService.getFile());
    }

    @PutMapping("/imageproduit")
    public void addFile(@RequestParam("file") MultipartFile file) {
        produitService.addFile(file);
    }

}
