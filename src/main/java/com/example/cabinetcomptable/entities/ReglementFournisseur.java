package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_fournisseur")
public class ReglementFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegF;

    @Column(unique = true)
    private String codeRF;
    private String modePaymant;
    private boolean status;
    private double avance;
    private double reste;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date datePayment;

    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;

    public ReglementFournisseur() {
    }

    public ReglementFournisseur(long idRegF, String codeRF, String modePaymant, boolean status, double avance, double reste, Date datePayment) {
        this.idRegF = idRegF;
        this.codeRF = codeRF;
        this.modePaymant = modePaymant;
        this.status = status;
        this.avance = avance;
        this.reste = reste;
        this.datePayment = datePayment;
    }

    public ReglementFournisseur(String codeRF, String modePaymant, boolean status, double avance, double reste, Date datePayment) {
        this.codeRF = codeRF;
        this.modePaymant = modePaymant;
        this.status = status;
        this.avance = avance;
        this.reste = reste;
        this.datePayment = datePayment;
    }

    public long getIdRegF() {
        return idRegF;
    }

    public void setIdRegF(long idRegF) {
        this.idRegF = idRegF;
    }

    public String getCodeRF() {
        return codeRF;
    }

    public void setCodeRF(String codeRF) {
        this.codeRF = codeRF;
    }

    public String getModePaymant() {
        return modePaymant;
    }

    public void setModePaymant(String modePaymant) {
        this.modePaymant = modePaymant;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    @JsonIgnore
    public BonAchat getBonAchat() {
        return bonAchat;
    }

    public void setBonAchat(BonAchat bonAchat) {
        this.bonAchat = bonAchat;
    }
}
