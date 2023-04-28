package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.services.BonAchatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BonAchatController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BonAchatService bonAchatService;

    @PostMapping("/bonAchat/next")
    public ResponseEntity<String> getNextBonANum(@RequestBody Date date){
        return ResponseEntity.ok(bonAchatService.getNextBonANum(date));
    }
    @PostMapping("/bonAchat/current/{id_ba}")
    public ResponseEntity<String> getcurrentBonANum(@PathVariable long id_ba,@RequestBody Date date){
        return ResponseEntity.ok(bonAchatService.getCurrentBonANum(id_ba,date));
    }

    // add bonAchat :
    @PostMapping("/bonAchat")
    public ResponseEntity<BonAchat> addBonAchat(@RequestBody BonAchat bonAchat) {
        return bonAchatService.addBonAchat(bonAchat);
    }

    // get BonAchat :
    @GetMapping("/bonAchat/{id_ba}")
    public ResponseEntity<BonAchat> getBonAchat(@PathVariable Long id_ba){
        return bonAchatService.getBonAchat(id_ba);
    }

    // get All BonAchat :
    @GetMapping("/bonAchat")
    public List<BonAchat> getAllBonAchats(){
        return bonAchatService.getAllBonAchats();
    }

    // update BonAchat :
    @PutMapping("/bonAchat/{id_ba}")
    public  ResponseEntity<BonAchat> updateBonAchat(@RequestBody BonAchat bonAchat , @PathVariable Long id_ba){
        return  ResponseEntity.ok( bonAchatService.updateBonAchat(bonAchat ,id_ba) );
    }

    // delete BonAchat :
    @DeleteMapping("/bonAchat/{id_ba}")
    public  boolean deleteBonAchat(@PathVariable Long id_ba){
        return bonAchatService.deleteBonAchat(id_ba);
    }


    // test :
    // get All BonAchat :
    @PostMapping ("/bonAchat/fournisseur")
    public ResponseEntity<List<BonAchat>>  getAllBonAchatsByFournisseur(@RequestBody Fournisseur fournisseur){
        return ResponseEntity.ok(bonAchatService.getAllBonAchatsByFournisseur(fournisseur));
    }

    @PutMapping("/bonAchat/regFournisseur/{id_ba}")
    public  ResponseEntity<BonAchat> updateBonAchatFromReglementFournisseur(@RequestBody BonAchat bonAchat , @PathVariable Long id_ba){
        return  ResponseEntity.ok( bonAchatService.updateBonAchatFromReglementFournisseur(bonAchat ,id_ba) );
    }

}
