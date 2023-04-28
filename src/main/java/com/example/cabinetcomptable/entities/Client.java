package com.example.cabinetcomptable.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@EntityListeners(AuditingEntityListener.class)
public class Client extends Personne{

    @Column(unique = true)
    private String codeC;

    private double bilan;
    private double pvBilan;
    private String regime;
    private double rTva;
    private double rCnss;

    @OneToMany(mappedBy="client")
    private Set<BonHonoraire> listBonHonoraire = new HashSet<BonHonoraire>();

    public Client(){
    }

    public Client(long id, String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction, String codeC, double bilan, double pvBilan, String regime, double rTva, double rCnss) {
        super(id, nom, image, email, telePortable, teleFix, ville, adresse, codePostale, siteWeb, ifi, ice, tp, cnss, rc, dateTransaction);
        this.codeC = codeC;
        this.bilan = bilan;
        this.pvBilan = pvBilan;
        this.regime = regime;
        this.rTva = rTva;
        this.rCnss = rCnss;
    }

    public Client(String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction, String codeC, double bilan, double pvBilan, String regime, double rTva, double rCnss) {
        super(nom, image, email, telePortable, teleFix, ville, adresse, codePostale, siteWeb, ifi, ice, tp, cnss, rc, dateTransaction);
        this.codeC = codeC;
        this.bilan = bilan;
        this.pvBilan = pvBilan;
        this.regime = regime;
        this.rTva = rTva;
        this.rCnss = rCnss;
    }

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    public double getBilan() {
        return bilan;
    }

    public void setBilan(double bilan) {
        this.bilan = bilan;
    }

    public double getPvBilan() {
        return pvBilan;
    }

    public void setPvBilan(double pvBilan) {
        this.pvBilan = pvBilan;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public double getrTva() {
        return rTva;
    }

    public void setrTva(double rTva) {
        this.rTva = rTva;
    }

    public double getrCnss() {
        return rCnss;
    }

    public void setrCnss(double rCnss) {
        this.rCnss = rCnss;
    }

    @JsonIgnore
    public Set<BonHonoraire> getListBonHonoraire() {
        return listBonHonoraire;
    }

    public void setListBonHonoraire(Set<BonHonoraire> listBonHonoraire) {
        this.listBonHonoraire = listBonHonoraire;
    }
}
