package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BonAchatRepository extends JpaRepository<BonAchat,Long> {

    @Query("select b from BonAchat b  where b.idBa =( select max(c.idBa) from BonAchat c where year(c.dateBa) = year(?1) ) ")
    BonAchat selectLastBonAchat(Date date);


    @Query("select b from BonAchat b where b.fournisseur =?1 and b.status=false and b.valide =true  ORDER BY b.dateBa ASC ")
    List<BonAchat> selectListBonAchatByFournisseur(Fournisseur fournisseur);

}
