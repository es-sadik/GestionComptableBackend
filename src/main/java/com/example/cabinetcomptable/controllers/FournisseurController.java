package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.entities.dto.FournisseurDto;
import com.example.cabinetcomptable.services.FournisseurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FournisseurController {
    //@Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    FournisseurService fournisseurService;

    @Autowired
    ServletContext context;

    // get fournisseur :
    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseurs(@PathVariable long id){
        return fournisseurService.getFournisseur(id);
    }

    // get All fournisseur :
    @GetMapping("fournisseurs")
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurService.getAllFournisseurs();
    }

    // add fournisseur :
    @PostMapping("/fournisseurs")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurService.addFournisseur(fournisseur);
    }

    // update fournisseur :
    @PutMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur ,@PathVariable long id){
        return fournisseurService.updateFournisseur(fournisseur,id);
    }

    // delete fournisseur :
    @DeleteMapping("/fournisseurs/{id}")
    public boolean  deleteFournisseur(@PathVariable long id){
        return fournisseurService.deleteFournisseur(id);
    }

    @GetMapping("/imagefournisseur")
    public ResponseEntity<String> getImage(){
        return ResponseEntity.ok(fournisseurService.getFile());
    }

    @PutMapping("/imagefournisseur")
    public void addFile(@RequestParam("file") MultipartFile file) {
        fournisseurService.addFile(file);
    }

    //
    @GetMapping("fournisseurDto/{id}")
    public ResponseEntity<FournisseurDto> getFournisseurWithListBonAchat(@PathVariable(name = "id") long id) {

        Fournisseur fournisseur = fournisseurService.getFournisseurWithListBonAchat(id);
        FournisseurDto fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);

        return ResponseEntity.ok(fournisseurDto);
    }
}
