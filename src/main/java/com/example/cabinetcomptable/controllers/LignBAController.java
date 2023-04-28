package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.LignBA;
import com.example.cabinetcomptable.services.LignBAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LignBAController {

    @Autowired
    private LignBAService lignBAService;


    // add lignBA :
    @PostMapping("/lignBA")
    public ResponseEntity<LignBA> addLignBA(@RequestBody LignBA lignBA) {
        return lignBAService.addLignBA(lignBA);
    }

    @PostMapping("/lignBA/list")
    public ResponseEntity<List<LignBA>>  addListLignBA(@RequestBody List<LignBA> listLignBA){
        return  ResponseEntity.ok(lignBAService.addListLignBA(listLignBA));
    }

    // getLignBA :
    @GetMapping("/lignBA/{id_ba}")
    public ResponseEntity<LignBA> getLignBA(@PathVariable Long id_ba){
        return lignBAService.getLignBA(id_ba);
    }

    // get AllLignBA :
    @GetMapping("/lignBA")
    public List<LignBA> getAllLignBAs(){
        return lignBAService.getAllLignBAs();
    }

    // updateLignBA :
    @PutMapping("/lignBA/{id_ba}")
    public  ResponseEntity<LignBA> updateLignBA(@RequestBody LignBA lignBA , @PathVariable Long id_ba){
        return  lignBAService.updateLignBA(lignBA ,id_ba);
    }

    // deleteLignBA :
    @DeleteMapping("/lignBA/{id_ba}")
    public  void deleteLignBA(@PathVariable Long id_ba){
        lignBAService.deleteLignBA(id_ba);
    }

}
