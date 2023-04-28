package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonHonoraire;
import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.services.BonHonoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BonHonoraireController {




    @Autowired
    private BonHonoraireService bonHonoraireService;

    @PostMapping("/bonHonoraire/next")
    public ResponseEntity<String> getNextBonANum(@RequestBody Date date){
        return ResponseEntity.ok(bonHonoraireService.getNextBonHNum(date));
    }
    @PostMapping("/bonHonoraire/current/{id_bh}")
    public ResponseEntity<String> getcurrentBonANum(@PathVariable long id_bh,@RequestBody Date date){
        return ResponseEntity.ok(bonHonoraireService.getCurrentBonHNum(id_bh,date));
    }

    // add bonHonoraire :
    @PostMapping("/bonHonoraire")
    public ResponseEntity<BonHonoraire> addBonHonoraire(@RequestBody BonHonoraire bonHonoraire) {
        System.out.println("==============================");
        System.out.println(bonHonoraire.getListLignBH());
        return bonHonoraireService.addBonHonoraire(bonHonoraire);
    }

    // get BonHonoraire :
    @GetMapping("/bonHonoraire/{id_bh}")
    public ResponseEntity<BonHonoraire> getBonHonoraire(@PathVariable Long id_bh){
        return bonHonoraireService.getBonHonoraire(id_bh);
    }

    // get All BonHonoraire :
    @GetMapping("/bonHonoraire")
    public List<BonHonoraire> getAllBonHonoraires(){
        return bonHonoraireService.getAllBonHonoraires();
    }

    // update BonHonoraire :
    @PutMapping("/bonHonoraire/{id_bh}")
    public  ResponseEntity<BonHonoraire> updateBonHonoraire(@RequestBody BonHonoraire bonHonoraire , @PathVariable Long id_bh){
        return  ResponseEntity.ok( bonHonoraireService.updateBonHonoraire(bonHonoraire ,id_bh) );
    }

    // delete BonHonoraire :
    @DeleteMapping("/bonHonoraire/{id_bh}")
    public  boolean deleteBonHonoraire(@PathVariable Long id_bh){
        return bonHonoraireService.deleteBonHonoraire(id_bh);
    }

    // test :
    // get All BonHonoraire :
    @PostMapping ("/bonHonoraire/client")
    public ResponseEntity<List<BonHonoraire>>  getAllBonHonorairesByClient(@RequestBody Client client){
        return ResponseEntity.ok(bonHonoraireService.getAllBonHonorairesByClient(client));
    }

    @PutMapping("/bonHonoraire/regClient/{id_bh}")
    public  ResponseEntity<BonHonoraire> updateBonHonoraireFromReglementClient(@RequestBody BonHonoraire bonHonoraire , @PathVariable Long id_bh){
        return  ResponseEntity.ok( bonHonoraireService.updateBonHonoraireFromReglementClient(bonHonoraire ,id_bh) );
    }

}
