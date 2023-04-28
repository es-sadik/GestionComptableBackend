package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.FournisseurRepository;
import com.example.cabinetcomptable.services.FileStorageService;
import com.example.cabinetcomptable.services.FournisseurService;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    FileStorageService fileStorageService ;

    @Autowired
    ServletContext context;

    @Autowired
    private GenerateFormatService generateFormatService ;

    private String pathFolder = "fournisseurImages";

    private static Fournisseur currentFournisseur  =null;


    public  FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }

    @Transactional
    @Override
    public ResponseEntity<Fournisseur> addFournisseur(Fournisseur fournisseur) {

        currentFournisseur = fournisseurRepository.save(fournisseur);
        currentFournisseur.setCodeF(generateFormatService.formatCodeFournisseur(currentFournisseur.getId()));
        return  ResponseEntity.ok(fournisseur);
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseur(long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        return ResponseEntity.ok(currentFournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<Fournisseur> updateFournisseur(Fournisseur fournisseur, long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        fournisseur.setId(id);
        fournisseur.setImage(currentFournisseur.getImage());
        currentFournisseur = fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(fournisseur);
    }
    @Override
    public boolean deleteFournisseur(long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        if(currentFournisseur.getListBonAchat().isEmpty()){
            fileStorageService.deleteFile(pathFolder+"/"+currentFournisseur.getImage());
            fournisseurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void addFile(MultipartFile file) {
        if(currentFournisseur.getImage() !=null){
            fileStorageService.deleteFile(pathFolder+"/"+currentFournisseur.getImage());
        }
        currentFournisseur.setImage(fileStorageService.uploadFile(file,pathFolder));
        currentFournisseur =fournisseurRepository.save(currentFournisseur);

    }
    @Override
    public String getFile() {
        return fileStorageService.loadFile(pathFolder+"/"+currentFournisseur.getImage());

    }
    //
    @Override
    public Fournisseur getFournisseurWithListBonAchat(long id){

        Fournisseur fournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));

        for(BonAchat currentValue: fournisseur.getListBonAchat() ){
            if(!currentValue.isValide()){
                fournisseur.getListBonAchat().remove(currentValue);
            }
        }

        return fournisseur;
    }





}
