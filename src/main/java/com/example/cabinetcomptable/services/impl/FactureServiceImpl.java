package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Facture;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.FactureRepository;
import com.example.cabinetcomptable.repositories.LignBHRepository;
import com.example.cabinetcomptable.services.FactureService;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    LignBHRepository lignBHRepository;

    @Autowired
    GenerateFormatService generateFormatService;


    private static Facture currentFacture  =null;

    public  FactureServiceImpl(FactureRepository factureRepository){
        this.factureRepository=factureRepository ;
    }

    @Override
    public String getNextFactureNum(Date date){
        return generateFormatService.formatNextNumeroFacture(date);
    }



    @Override

    public ResponseEntity<Facture> addFacture(Facture facture) {
        facture.setFacNum(generateFormatService.formatNextNumeroFacture(facture.getDateFac()));
        currentFacture = factureRepository.save(facture);
        return ResponseEntity.ok(facture);

    }

    @Override
    public Facture getFacture(long idFac) {
        currentFacture = factureRepository.findById(idFac).orElseThrow(() -> new ResourceNotFoundException("Facture not found for this reference :: " + idFac));
        return currentFacture;
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }



    @Override
    public void deleteFacture(long idFac) {
        currentFacture = factureRepository.findById(idFac).orElseThrow(() -> new ResourceNotFoundException("Facture not found for this reference :: " + idFac));
        System.out.println(idFac);
        factureRepository.deleteById(idFac);
    }








}
