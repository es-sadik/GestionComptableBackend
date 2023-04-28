package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LignBHRepository extends JpaRepository<LignBH,Long> {
    @Query(nativeQuery = true, value = "SELECT p.designation  FROM lign_bh l INNER JOIN bon_honoraire b USING(id_bh) INNER JOIN produit p  USING(reference) where b.valide = true GROUP BY l.reference ORDER BY SUM(quantite) desc LIMIT 5")
    List<String> selectDesignationTop5ByOrderByQuantitieOfLignBH();

    @Query(nativeQuery = true, value = "SELECT sum(l.quantite)  FROM lign_bh l INNER JOIN bon_honoraire b USING(id_bh) INNER JOIN produit p  USING(reference) where b.valide = true GROUP BY l.reference ORDER BY SUM(quantite) desc LIMIT 5")
    List <String> selectSumQuantiteTop5ByOrderByQuantitieOfLignBH();
}
