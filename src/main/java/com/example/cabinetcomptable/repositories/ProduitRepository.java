package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,String> {

    List<Produit> findTop5ByOrderByQuantitieDisponibleDesc();

    @Query(value = "select p from Produit p order by p.categorie.nomCat ")
    List<Produit> selectProduitsOrderByCategorie();


}
