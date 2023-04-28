package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFac;

    @Column(unique = true)
    private String facNum;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateFac;

    private double totalHt;
    private double totalTva;
    private double totalTtc;

    @OneToOne
    @JoinColumn(name = "id_bh")
    private BonHonoraire bonHonoraire;

    public Facture() {
    }

    public Facture(long idFac, String facNum, Date dateFac, double totalHt, double totalTva, double totalTtc) {
        this.idFac = idFac;
        this.facNum = facNum;
        this.dateFac = dateFac;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public Facture(String facNum, Date dateFac, double totalHt, double totalTva, double totalTtc) {
        this.facNum = facNum;
        this.dateFac = dateFac;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public long getIdFac() {
        return idFac;
    }

    public void setIdFac(long idFac) {
        this.idFac = idFac;
    }

    public String getFacNum() {
        return facNum;
    }

    public void setFacNum(String facNum) {
        this.facNum = facNum;
    }

    public Date getDateFac() {
        return dateFac;
    }

    public void setDateFac(Date dateFac) {
        this.dateFac = dateFac;
    }

    public double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(double totalHt) {
        this.totalHt = totalHt;
    }

    public double getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(double totalTva) {
        this.totalTva = totalTva;
    }

    public double getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(double totalTtc) {
        this.totalTtc = totalTtc;
    }

    @JsonIgnore
    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }
}
