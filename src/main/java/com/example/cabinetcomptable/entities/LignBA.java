package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "lign_ba")
public class LignBA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLignA;
    private int quantite;
    private double montantTtc;
    private double prixUnitaire;
    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;

    @ManyToOne
    @JoinColumn(name ="reference")
    private Produit produit;


    public LignBA() {
    }

    public LignBA(long idLignA, int quantite, double montantTtc, double prixUnitaire) {
        this.idLignA = idLignA;
        this.quantite = quantite;
        this.montantTtc = montantTtc;
        this.prixUnitaire = prixUnitaire;
    }

    public LignBA(int quantite, double montantTtc, double prixUnitaire) {
        this.quantite = quantite;
        this.montantTtc = montantTtc;
        this.prixUnitaire = prixUnitaire;
    }

    public long getIdLignA() {
        return idLignA;
    }

    public void setIdLignA(long idLignA) {
        this.idLignA = idLignA;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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
    public BonAchat getBonAchat() {
        return bonAchat;
    }

    public void setBonAchat(BonAchat bonAchat) {
        this.bonAchat = bonAchat;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


}
