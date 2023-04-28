package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bon_achat")

public class BonAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBa;

    @Column(unique = true)
    private String bonANum;

    private String facBonNum;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateBa;

    private  boolean valide;
    private  boolean status;

    private double montantTotal;

    private double montantPayer;


    @ManyToOne
    @JoinColumn( name = "id_f" )
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonAchat",cascade = CascadeType.ALL)
    private Set<ReglementFournisseur> listReglementFournisseur = new HashSet<ReglementFournisseur>();

    @OneToMany(mappedBy = "bonAchat",cascade = CascadeType.ALL)
    private Set<LignBA> listLignBA = new HashSet<LignBA>();

    public BonAchat() {
    }

    public BonAchat(long idBa, String bonANum, String facBonNum, Date dateBa, boolean valide, boolean status, double montantTotal, double montantPayer) {
        this.idBa = idBa;
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
        this.valide = valide;
        this.status = status;
        this.montantTotal = montantTotal;
        this.montantPayer = montantPayer;
    }

    public BonAchat(String bonANum, String facBonNum, Date dateBa, boolean valide, boolean status, double montantTotal, double montantPayer) {
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
        this.valide = valide;
        this.status = status;
        this.montantTotal = montantTotal;
        this.montantPayer = montantPayer;
    }

    public long getIdBa() {
        return idBa;
    }

    public void setIdBa(long idBa) {
        this.idBa = idBa;
    }

    public String getBonANum() {
        return bonANum;
    }

    public void setBonANum(String bonANum) {
        this.bonANum = bonANum;
    }

    public String getFacBonNum() {
        return facBonNum;
    }

    public void setFacBonNum(String facBonNum) {
        this.facBonNum = facBonNum;
    }

    public Date getDateBa() {
        return dateBa;
    }

    public void setDateBa(Date dateBa) {
        this.dateBa = dateBa;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(double montantPayer) {
        this.montantPayer = montantPayer;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Set<ReglementFournisseur> getListReglementFournisseur() {
        return listReglementFournisseur;
    }

    public void setListReglementFournisseur(Set<ReglementFournisseur> listReglementFournisseur) {
        this.listReglementFournisseur = listReglementFournisseur;
    }

    public Set<LignBA> getListLignBA() {
        return listLignBA;
    }

    public void setListLignBA(Set<LignBA> listLignBA) {
        this.listLignBA = listLignBA;
    }
}
