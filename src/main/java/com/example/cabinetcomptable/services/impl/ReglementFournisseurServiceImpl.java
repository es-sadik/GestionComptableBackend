package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import com.example.cabinetcomptable.repositories.ReglementFournisseurRepository;
import com.example.cabinetcomptable.services.GenerateFormatService;
import com.example.cabinetcomptable.services.ReglementFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Service
public class ReglementFournisseurServiceImpl implements ReglementFournisseurService {

    @Autowired
    GenerateFormatService generateFormatService;
    @Autowired
    private ReglementFournisseurRepository reglementFournisseurRepository;

    private static  ReglementFournisseur currentreglementFournisseur = null ;

    public ReglementFournisseurServiceImpl(ReglementFournisseurRepository reglementFournisseurRepository) {
        this.reglementFournisseurRepository = reglementFournisseurRepository;
    }

    @Override
    public String getNextCodeReglementFournisseur(Date date){
        return generateFormatService.formatNextCodeReglementFournisseur(date);
    }
    @Override
    public ResponseEntity<ReglementFournisseur> addReglementFournisseur(ReglementFournisseur reglementFournisseur) {

        reglementFournisseur.setCodeRF(generateFormatService.formatNextCodeReglementFournisseur( reglementFournisseur.getDatePayment() ));

        currentreglementFournisseur = reglementFournisseurRepository.save(reglementFournisseur);

        return ResponseEntity.ok(currentreglementFournisseur);
    }
    @Override
    public List<ReglementFournisseur> addListReglementFournisseur(List<ReglementFournisseur> listReglementFournisseur) {
        for(ReglementFournisseur currenValue : listReglementFournisseur){
            currenValue.setCodeRF(generateFormatService.formatNextCodeReglementFournisseur( currenValue.getDatePayment() ));
            currentreglementFournisseur =reglementFournisseurRepository.saveAndFlush(currenValue);
        }

        return  listReglementFournisseur;

    }

    @Override
    public ResponseEntity<ReglementFournisseur> getReglementFournisseur(long id_reg_f) {

       currentreglementFournisseur = reglementFournisseurRepository.findById(id_reg_f).orElseThrow();
        return ResponseEntity.ok(currentreglementFournisseur);
    }

    @Override
    public List<ReglementFournisseur> getAllReglementFournisseurs() {
        return reglementFournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<ReglementFournisseur> updateReglementFournisseur(long id_reg_f, ReglementFournisseur reglementFournisseur) {
        currentreglementFournisseur = reglementFournisseurRepository.findById(id_reg_f).orElseThrow();
        reglementFournisseur.setIdRegF(id_reg_f);
        currentreglementFournisseur =reglementFournisseurRepository.save(reglementFournisseur);

        return ResponseEntity.ok(reglementFournisseur);
    }

    @Override
    public void deleteReglementFournisseur(long id_reg_f) {
         reglementFournisseurRepository.deleteById(id_reg_f);
    }

}

