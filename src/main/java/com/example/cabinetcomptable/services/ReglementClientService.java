package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.ReglementClient;
import com.example.cabinetcomptable.entities.ReglementClient;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ReglementClientService {
    
    String getNextCodeReglementClient(Date date);

    ResponseEntity<ReglementClient> addReglementClient(ReglementClient reglementClient) ;
    ResponseEntity<ReglementClient> getReglementClient(long id_reg_f);
    List<ReglementClient> addListReglementClient(List<ReglementClient> listReglementClient );
    List<ReglementClient> getAllReglementClients();
    ResponseEntity<ReglementClient> updateReglementClient(long id_reg_f, ReglementClient reglementClient);
    void deleteReglementClient(long id_reg_f);
}
