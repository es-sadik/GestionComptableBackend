package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCat;
    private String nomCat;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> listProduit ;


    public Categorie() {
    }

    public Categorie(long idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }

    public Categorie(String nomCat) {
        this.nomCat = nomCat;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    @JsonIgnore
    public List<Produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(List<Produit> listProduit) {
        this.listProduit = listProduit;
    }


}
