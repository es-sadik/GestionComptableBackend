package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ReglementFournisseurRepository extends JpaRepository<ReglementFournisseur,Long> {

    @Query("select r from ReglementFournisseur r  where r.idRegF =( select max(c.idRegF) from ReglementFournisseur c where year(c.datePayment) = year(?1) ) ")
    ReglementFournisseur selectLasReglementFournisseur(Date date);

    @Query(" select sum(r.avance) from ReglementFournisseur r where year(r.datePayment) = year(?1)  ")
    Double selectSumOfDepensePerYear(Date date);

    @Query(" select sum(r.avance) from ReglementFournisseur r where month(r.datePayment) = month(?1) and year (r.datePayment) = year(?1) ")
    Double selectSumOfDepensePerMonth(Date date);
}
