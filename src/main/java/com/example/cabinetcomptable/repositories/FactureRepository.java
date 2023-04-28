package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
    @Query("select f from Facture f  where f.idFac =( select max(c.idFac) from Facture c where year(c.dateFac) = year(?1) ) ")
    Facture selectLastFacture(Date date);
}
