package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.ReglementClient;
import com.example.cabinetcomptable.entities.ReglementClient;
import com.example.cabinetcomptable.repositories.ReglementClientRepository;
import com.example.cabinetcomptable.services.GenerateFormatService;
import com.example.cabinetcomptable.services.ReglementClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ReglementClientServiceImpl implements ReglementClientService {


    @Autowired
    GenerateFormatService generateFormatService;
    @Autowired
    private ReglementClientRepository reglementClientRepository;

    private static ReglementClient currentreglementClient = null ;

    public ReglementClientServiceImpl(ReglementClientRepository reglementClientRepository) {
        this.reglementClientRepository = reglementClientRepository;
    }

    @Override
    public String getNextCodeReglementClient(Date date){
        return generateFormatService.formatNextCodeReglementClient(date);
    }


    @Override
    public ResponseEntity<ReglementClient> addReglementClient(ReglementClient reglementClient) {

        reglementClient.setCodeRC(generateFormatService.formatNextCodeReglementClient( reglementClient.getDatePayment() ));
        currentreglementClient = reglementClientRepository.save(reglementClient);
        return ResponseEntity.ok(currentreglementClient);
    }

    @Override
    public ResponseEntity<ReglementClient> getReglementClient(long id_reg_c) {

        currentreglementClient = reglementClientRepository.findById(id_reg_c).orElseThrow();
        return ResponseEntity.ok(currentreglementClient);
    }

    @Override
    public List<ReglementClient> addListReglementClient(List<ReglementClient> listReglementClient) {
        for(ReglementClient currenValue : listReglementClient){
            currenValue.setCodeRC(generateFormatService.formatNextCodeReglementClient( currenValue.getDatePayment() ));
            currentreglementClient =reglementClientRepository.saveAndFlush(currenValue);

        }
        return  listReglementClient;
    }

    @Override
    public List<ReglementClient> getAllReglementClients() {

        return reglementClientRepository.findAll();
    }

    @Override
    public ResponseEntity<ReglementClient> updateReglementClient(long id_reg_c, ReglementClient reglementClient) {
        currentreglementClient = reglementClientRepository.findById(id_reg_c).orElseThrow();
        reglementClient.setIdRegC(id_reg_c);
        currentreglementClient =reglementClientRepository.save(reglementClient);

        return ResponseEntity.ok(reglementClient);
    }

    @Override
    public void deleteReglementClient(long id_reg_c) {
        reglementClientRepository.deleteById(id_reg_c);
    }

}
