package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.LignBH;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.LignBHRepository;
import com.example.cabinetcomptable.services.LignBHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LignBHServiceImpl implements LignBHService {

    @Autowired
    LignBHRepository lignBHRepository ;

    private static LignBH currentLignBH ;

    public LignBHServiceImpl(LignBHRepository lignBHRepository) {
        this.lignBHRepository = lignBHRepository;
    }

    @Override
    public ResponseEntity<LignBH> addLignBH(LignBH lignBA) {
        currentLignBH =lignBHRepository.save(lignBA);
        return  ResponseEntity.ok(lignBA);
    }
    @Override
    public List<LignBH> addListLignBH(List<LignBH> listLignBH){
        lignBHRepository.saveAll(listLignBH);
        return listLignBH;
    }

    @Override
    public ResponseEntity<LignBH> getLignBH(long id_lign_h) {
        currentLignBH = lignBHRepository.findById(id_lign_h).orElseThrow(() -> new ResourceNotFoundException("LignBH not found for this reference :: " + id_lign_h));
        return ResponseEntity.ok(currentLignBH);
    }

    @Override
    public List<LignBH> getAllLignBHs() {
        return lignBHRepository.findAll();
    }

    @Override
    public ResponseEntity<LignBH> updateLignBH(LignBH lignBA, long id_lign_h) {
        currentLignBH = lignBHRepository.findById(id_lign_h).orElseThrow(() -> new ResourceNotFoundException("LignBH not found for this reference :: " + id_lign_h));
        lignBA.setIdLignH(id_lign_h);

        currentLignBH = lignBHRepository.save(lignBA) ;

        return ResponseEntity.ok(lignBA);
    }

    @Override
    public void deleteLignBH(long id_lign_h) {
        currentLignBH = lignBHRepository.findById(id_lign_h).orElseThrow(() -> new ResourceNotFoundException("LignBH not found for this reference :: " + id_lign_h));

        lignBHRepository.deleteById(id_lign_h);

    }
}
