package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.entities.LignBA;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.BonAchatRepository;
import com.example.cabinetcomptable.repositories.LignBARepository;
import com.example.cabinetcomptable.services.BonAchatService;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class BonAchatServiceImpl implements BonAchatService {

    @Autowired
    BonAchatRepository bonAchatRepository;

    @Autowired
    LignBARepository lignBARepository;

    @Autowired
    GenerateFormatService generateFormatService;


    private static BonAchat currentBonAchat  =null;
    private static Set<LignBA> currentListLignBA  = null;

    public  BonAchatServiceImpl(BonAchatRepository bonAchatRepository){
        this.bonAchatRepository=bonAchatRepository ;
    }

    @Override
    public String getNextBonANum(Date date){
        return generateFormatService.formatNextNumeroBonAchat(date);
    }

    @Override
    public String getCurrentBonANum(long id, Date date){
        return generateFormatService.formatCurrentNumeroBonAchat(id,date);
    }

    @Override
    @Transactional
    public ResponseEntity<BonAchat> addBonAchat(BonAchat bonAchat) {


        bonAchat.setBonANum(generateFormatService.formatNextNumeroBonAchat(bonAchat.getDateBa()));
        currentListLignBA = bonAchat.getListLignBA();
        bonAchat.setListLignBA(null);
        currentBonAchat=bonAchatRepository.save(bonAchat);

        for (LignBA currentvalue : currentListLignBA) {
            currentvalue.setBonAchat(currentBonAchat);
        }

        currentBonAchat.setListLignBA(currentListLignBA);

        return ResponseEntity.ok(bonAchat);
    }

    @Override
    public ResponseEntity<BonAchat> getBonAchat(long idBa) {
        currentBonAchat = bonAchatRepository.findById(idBa).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + idBa));
        return ResponseEntity.ok(currentBonAchat);
    }

    @Override
    public List<BonAchat> getAllBonAchats() {
        return bonAchatRepository.findAll();
    }


    @Override
    public BonAchat updateBonAchat(BonAchat bonAchat, long idBa) {

        currentBonAchat = bonAchatRepository.findById(idBa).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this id :: " + idBa));

        currentListLignBA = currentBonAchat.getListLignBA();

        currentBonAchat.setListLignBA(null);
        lignBARepository.deleteAll(currentListLignBA);

        bonAchat.setIdBa(idBa);
        currentListLignBA = bonAchat.getListLignBA();
        bonAchat.setListLignBA(null);

        currentBonAchat = bonAchatRepository.save(bonAchat);

        for (LignBA currentvalue : currentListLignBA) {
            currentvalue.setBonAchat(currentBonAchat);
        }

        currentBonAchat.setListLignBA(currentListLignBA);

        currentBonAchat = bonAchatRepository.save(currentBonAchat);

        return currentBonAchat;
    }

    @Override
    public boolean deleteBonAchat(long idBa) {
        currentBonAchat = bonAchatRepository.findById(idBa).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + idBa));
        if(currentBonAchat.getListReglementFournisseur().isEmpty()){
            bonAchatRepository.deleteById(idBa);
            return true;
        }
        return false;

    }


    //
    @Override
    public  BonAchat getB(long id){
        Optional<BonAchat> result = bonAchatRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("walllllllllllllllo ");
        }
    }

    @Override

    public List<BonAchat> getAllBonAchatsByFournisseur(Fournisseur fournisseur){

        return bonAchatRepository.selectListBonAchatByFournisseur(fournisseur);
    }

    @Override
    public BonAchat updateBonAchatFromReglementFournisseur(BonAchat bonAchat, long idBa) {
        currentBonAchat = bonAchatRepository.findById(idBa).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this id :: " + idBa));
        bonAchat.setIdBa(idBa);
        bonAchat.setListLignBA(currentBonAchat.getListLignBA());
        bonAchat.setListReglementFournisseur(currentBonAchat.getListReglementFournisseur());
        currentBonAchat = bonAchatRepository.save(bonAchat);
        return currentBonAchat;
    }


}
