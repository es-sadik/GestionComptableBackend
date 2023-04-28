package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.BonHonoraire;
import com.example.cabinetcomptable.entities.Client;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface BonHonoraireService {
    String getNextBonHNum(Date date);

    String getCurrentBonHNum(long id, Date date);

    ResponseEntity<BonHonoraire> addBonHonoraire(BonHonoraire bonHonoraire);
    ResponseEntity<BonHonoraire> getBonHonoraire(long id_bh);
    List<BonHonoraire> getAllBonHonoraires();

    BonHonoraire updateBonHonoraireFromReglementClient(BonHonoraire bonHonoraire, long id_bh);

    BonHonoraire updateBonHonoraire(BonHonoraire BonHonoraireDtails , long id_bh);
    boolean deleteBonHonoraire(long id_bh);

    //
    BonHonoraire getB(long id);

    List<BonHonoraire> getAllBonHonorairesByClient(Client client);

}
