package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.ReglementClient;
import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReglementClientRepository extends JpaRepository<ReglementClient,Long> {

    @Query("select r from ReglementClient r  where r.idRegC =( select max(rc.idRegC) from ReglementClient rc where year(rc.datePayment) = year(?1) ) ")
    ReglementClient selectLasReglementClient(Date date);

    @Query(" select sum(r.avance) from ReglementClient r where year(r.datePayment) = year(?1)  ")
    Double selectSumOfRecettePerYear(Date date);

    @Query(" select sum(r.avance) from ReglementClient r where month(r.datePayment) = month(?1) and year (r.datePayment) = year(?1) ")
    Double selectSumOfRecettePerMonth(Date date);
}
