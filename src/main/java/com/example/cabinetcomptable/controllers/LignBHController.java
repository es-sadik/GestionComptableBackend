package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.LignBH;
import com.example.cabinetcomptable.services.LignBHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LignBHController {

    @Autowired
    private LignBHService lignBHService;


    // add lignBH :
    @PostMapping("/lignBH")
    public ResponseEntity<LignBH> addLignBH(@RequestBody LignBH lignBH) {
        return lignBHService.addLignBH(lignBH);
    }

    @PostMapping("/lignBH/list")
    public ResponseEntity<List<LignBH>>  addListLignBH(@RequestBody List<LignBH> listLignBH){
        return  ResponseEntity.ok(lignBHService.addListLignBH(listLignBH));
    }

    // getLignBH :
    @GetMapping("/lignBH/{id_bh}")
    public ResponseEntity<LignBH> getLignBH(@PathVariable Long id_bh){
        return lignBHService.getLignBH(id_bh);
    }

    // get AllLignBH :
    @GetMapping("/lignBH")
    public List<LignBH> getAllLignBHs(){
        return lignBHService.getAllLignBHs();
    }

    // updateLignBH :
    @PutMapping("/lignBH/{id_bh}")
    public  ResponseEntity<LignBH> updateLignBH(@RequestBody LignBH lignBH , @PathVariable Long id_bh){
        return  lignBHService.updateLignBH(lignBH ,id_bh);
    }

    // deleteLignBH :
    @DeleteMapping("/lignBH/{id_bh}")
    public  void deleteLignBH(@PathVariable Long id_bh){
        lignBHService.deleteLignBH(id_bh);
    }

}
