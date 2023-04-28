package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

    @Query("select distinct f from Fournisseur f join f.listBonAchat b where f.id = ?1  and  b.valide = true ")
    Fournisseur findByIdWhereListBonAchatIsValide(long id);
}
