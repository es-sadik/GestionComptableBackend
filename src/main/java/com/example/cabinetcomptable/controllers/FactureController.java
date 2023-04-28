package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Facture;
import com.example.cabinetcomptable.entities.dto.FactureDto;
import com.example.cabinetcomptable.services.FactureService;
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
public class FactureController {

    @Autowired
    private FactureService factureService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/factures/next")
    public ResponseEntity<String> getNextFactureNum(@RequestBody Date date){
        return ResponseEntity.ok(factureService.getNextFactureNum(date));
    }
   
    // get facture :
    @GetMapping("/factures/{idFac}")
    public ResponseEntity<FactureDto> getFacture(@PathVariable long idFac) {
        FactureDto factureDto = modelMapper.map(factureService.getFacture(idFac), FactureDto.class);
        return ResponseEntity.ok(factureDto);
    }

    // get factures :
    @GetMapping("/factures")
    public ResponseEntity< List<FactureDto> > getAllFactures(){
        List<FactureDto> listFactureDto = factureService.getAllFactures().stream().map(f -> modelMapper.map(f, FactureDto.class)).collect(Collectors.toList());

        return ResponseEntity.ok(listFactureDto);
    }

    // add Facture :
    @PostMapping( "/factures")
    public ResponseEntity<Facture> addFacture(@RequestBody FactureDto factureDto) {
        Facture facture = modelMapper.map(factureDto, Facture.class);
        return  factureService.addFacture(facture);
    }

 
    // delete facture :
    @DeleteMapping("factures/{idFac}")
    public void deleteFacture(@PathVariable long idFac){
        factureService.deleteFacture(idFac);
    }



}
