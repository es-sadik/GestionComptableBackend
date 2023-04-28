package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.LignBA;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.LignBARepository;
import com.example.cabinetcomptable.services.LignBAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LignBAServiceImpl implements LignBAService {

    @Autowired
    LignBARepository lignBARepository ;

    private static LignBA currentLignBA ;

    public LignBAServiceImpl(LignBARepository lignBARepository) {
        this.lignBARepository = lignBARepository;
    }

    @Override
    public ResponseEntity<LignBA> addLignBA(LignBA lignBA) {
        currentLignBA =lignBARepository.save(lignBA);
        return  ResponseEntity.ok(lignBA);
    }
    @Override
    public List<LignBA> addListLignBA(List<LignBA> listLignBA){
        lignBARepository.saveAll(listLignBA);
        return listLignBA;
    }

    @Override
    public ResponseEntity<LignBA> getLignBA(long id_lign_a) {
        currentLignBA = lignBARepository.findById(id_lign_a).orElseThrow(() -> new ResourceNotFoundException("LignBA not found for this reference :: " + id_lign_a));
        return ResponseEntity.ok(currentLignBA);
    }

    @Override
    public List<LignBA> getAllLignBAs() {
        return lignBARepository.findAll();
    }

    @Override
    public ResponseEntity<LignBA> updateLignBA(LignBA lignBA, long id_lign_a) {
        currentLignBA = lignBARepository.findById(id_lign_a).orElseThrow(() -> new ResourceNotFoundException("LignBA not found for this reference :: " + id_lign_a));
        lignBA.setIdLignA(id_lign_a);

        currentLignBA = lignBARepository.save(lignBA) ;

        return ResponseEntity.ok(lignBA);
    }

    @Override
    public void deleteLignBA(long id_lign_a) {
        currentLignBA = lignBARepository.findById(id_lign_a).orElseThrow(() -> new ResourceNotFoundException("LignBA not found for this reference :: " + id_lign_a));

        lignBARepository.deleteById(id_lign_a);

    }
}
