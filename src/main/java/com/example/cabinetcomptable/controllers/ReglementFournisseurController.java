package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import com.example.cabinetcomptable.entities.dto.ReglementFournisseurDto;
import com.example.cabinetcomptable.services.ReglementFournisseurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReglementFournisseurController {

    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    private ReglementFournisseurService reglementFournisseurService;


    // get ReglementFournisseur :

    @PostMapping("/reglementFournisseurs/next")
    public ResponseEntity<String> getNextCodeRF(@RequestBody Date date){
        return ResponseEntity.ok(reglementFournisseurService.getNextCodeReglementFournisseur(date));
    }

    @GetMapping("reglementFournisseurs/{id_reg_f}")
    public ResponseEntity<ReglementFournisseur> getReglementFournisseur(@PathVariable long id_reg_f){
        return reglementFournisseurService.getReglementFournisseur(id_reg_f);
    }

    // get BonARegs :

    @GetMapping("reglementFournisseurs")
    public List<ReglementFournisseurDto> getAllReglementFournisseurs(){

        List<ReglementFournisseurDto> ListReglementFournisseurDto = reglementFournisseurService.getAllReglementFournisseurs().stream().map(r -> modelMapper.map(r, ReglementFournisseurDto.class)).collect(Collectors.toList());

        return ListReglementFournisseurDto;
    }

    // add ReglementFournisseur :
    @PostMapping("reglementFournisseurs")
    public ResponseEntity<ReglementFournisseur> addReglementFournisseur(@RequestBody ReglementFournisseurDto reglementFournisseurDto){
        ReglementFournisseur reglementFournisseur = modelMapper.map(reglementFournisseurDto, ReglementFournisseur.class);

        return  reglementFournisseurService.addReglementFournisseur(reglementFournisseur);
    }

    @PostMapping("reglementFournisseurs/addList")
    public ResponseEntity<List<ReglementFournisseur>> addListReglementFournisseur(@RequestBody List<ReglementFournisseurDto> listReglementFournisseurDto){

        List<ReglementFournisseur> listReglementFournisseur = listReglementFournisseurDto.stream().map(r -> modelMapper.map(r, ReglementFournisseur.class)).collect(Collectors.toList());

        return ResponseEntity.ok( reglementFournisseurService.addListReglementFournisseur(listReglementFournisseur) );
    }

    // update ReglementFournisseur :
    @PutMapping("/reglementFournisseurs/{id_reg_f}")
    public void updateReglementFournisseur(@PathVariable long id_reg_f , @RequestBody ReglementFournisseur reglementFournisseur){
        reglementFournisseurService.updateReglementFournisseur(id_reg_f,reglementFournisseur);
    }

    // Delete ReglementFournisseur  :
    @DeleteMapping("/reglementFournisseurs/{id_reg_f}")
    public  void deleteReglementFournisseur(@PathVariable long id_reg_f){
        reglementFournisseurService.deleteReglementFournisseur(id_reg_f);
    }


}
