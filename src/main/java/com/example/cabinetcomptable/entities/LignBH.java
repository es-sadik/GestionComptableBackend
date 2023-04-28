package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "lign_bh")
public class LignBH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLignH;
    private int quantite;
    private double montantTtc;
    
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn( name = "id_bh" )
    private BonHonoraire bonHonoraire;

    @ManyToOne
    @JoinColumn(name ="reference")
    private Produit produit;

    public LignBH() {
    }

    public LignBH(long idLignH, int quantite, double montantTtc) {
        this.idLignH = idLignH;
        this.quantite = quantite;
        this.montantTtc = montantTtc;
    }

    public long getIdLignH() {
        return idLignH;
    }

    public void setIdLignH(long idLignH) {
        this.idLignH = idLignH;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montantTtc;
    }

    public void setMontant(double montantTtc) {
        this.montantTtc = montantTtc;
    }

    public double getMontantTtc() {
        return montantTtc;
    }

    public void setMontantTtc(double montantTtc) {
        this.montantTtc = montantTtc;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @JsonIgnore
    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
