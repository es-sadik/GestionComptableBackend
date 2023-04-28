package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonHonoraire;
import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.entities.LignBH;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.BonHonoraireRepository;
import com.example.cabinetcomptable.repositories.LignBHRepository;
import com.example.cabinetcomptable.services.BonHonoraireService;
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
public class BonHonoraireServiceImpl implements BonHonoraireService {

    @Autowired
    BonHonoraireRepository bonHonoraireRepository;

    @Autowired
    LignBHRepository lignBHRepository;

    @Autowired
    GenerateFormatService generateFormatService;


    private static BonHonoraire currentBonHonoraire  =null;
    private static Set<LignBH> currentListLignBH  = null;

    public  BonHonoraireServiceImpl(BonHonoraireRepository bonHonoraireRepository){
        this.bonHonoraireRepository=bonHonoraireRepository ;
    }

    @Override
    public String getNextBonHNum(Date date){
        return generateFormatService.formatNextNumeroBonHonoraire(date);
    }

    @Override
    public String getCurrentBonHNum(long id, Date date){
        return generateFormatService.formatCurrentNumeroBonHonoraire(id,date);
    }

    @Override
    @Transactional
    public ResponseEntity<BonHonoraire> addBonHonoraire(BonHonoraire bonHonoraire) {


        bonHonoraire.setBonHNum(generateFormatService.formatNextNumeroBonHonoraire(bonHonoraire.getDateBh()));
        currentListLignBH = bonHonoraire.getListLignBH();

        bonHonoraire.setListLignBH(null);
        currentBonHonoraire=bonHonoraireRepository.save(bonHonoraire);

        for (LignBH currentvalue : currentListLignBH) {
            currentvalue.setBonHonoraire(currentBonHonoraire);
        }

        currentBonHonoraire.setListLignBH(currentListLignBH);

        return ResponseEntity.ok(bonHonoraire);
    }

    @Override
    public ResponseEntity<BonHonoraire> getBonHonoraire(long idBa) {
        currentBonHonoraire = bonHonoraireRepository.findById(idBa).orElseThrow(() -> new ResourceNotFoundException("BonHonoraire not found for this reference :: " + idBa));
        return ResponseEntity.ok(currentBonHonoraire);
    }

    @Override
    public List<BonHonoraire> getAllBonHonoraires() {
        return bonHonoraireRepository.findAll();
    }


    @Override
    public BonHonoraire updateBonHonoraire(BonHonoraire bonHonoraire, long idBh) {

        currentBonHonoraire = bonHonoraireRepository.findById(idBh).orElseThrow(() -> new ResourceNotFoundException("BonHonoraire not found for this id :: " + idBh));

        currentListLignBH = currentBonHonoraire.getListLignBH();

        currentBonHonoraire.setListLignBH(null);
        lignBHRepository.deleteAll(currentListLignBH);

        bonHonoraire.setIdBh(idBh);
        currentListLignBH = bonHonoraire.getListLignBH();
        bonHonoraire.setListLignBH(null);

        currentBonHonoraire = bonHonoraireRepository.save(bonHonoraire);

        for (LignBH currentvalue : currentListLignBH) {
            currentvalue.setBonHonoraire(currentBonHonoraire);
        }

        currentBonHonoraire.setListLignBH(currentListLignBH);

        currentBonHonoraire = bonHonoraireRepository.save(currentBonHonoraire);

        return currentBonHonoraire;
    }

    @Override
    public boolean deleteBonHonoraire(long idBh) {
        currentBonHonoraire = bonHonoraireRepository.findById(idBh).orElseThrow(() -> new ResourceNotFoundException("BonHonoraire not found for this reference :: " + idBh));
        if(currentBonHonoraire.getFacture() == null && currentBonHonoraire.getListReglementClient().isEmpty() ){
            bonHonoraireRepository.deleteById(idBh);
            return true;
        }
        return false;
    }


    //
    @Override
    public  BonHonoraire getB(long id){
        Optional<BonHonoraire> result = bonHonoraireRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("walllllllllllllllo ");
        }
    }

    @Override

    public List<BonHonoraire> getAllBonHonorairesByClient(Client client){
        return bonHonoraireRepository.selectListBonHonoraireByClient(client);
    }

    @Override
    public BonHonoraire updateBonHonoraireFromReglementClient(BonHonoraire bonHonoraire, long idBh) {
        currentBonHonoraire = bonHonoraireRepository.findById(idBh).orElseThrow(() -> new ResourceNotFoundException("BonHonoraire not found for this id :: " + idBh));
        bonHonoraire.setIdBh(idBh);
        bonHonoraire.setListLignBH(currentBonHonoraire.getListLignBH());
        bonHonoraire.setListReglementClient(currentBonHonoraire.getListReglementClient());
        bonHonoraire.setFacture(currentBonHonoraire.getFacture());
        currentBonHonoraire = bonHonoraireRepository.save(bonHonoraire);
        return currentBonHonoraire;
    }


}
