package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fournisseurs")

public class Fournisseur extends Personne{

    @Column(unique = true)
    private String codeF;

    @OneToMany(mappedBy="fournisseur",cascade = CascadeType.ALL)
    private Set<BonAchat> listBonAchat = new HashSet<BonAchat>();

    public Fournisseur() {
      super();
    }

    public Fournisseur(long id, String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, String ifi, String ice, String tp, String cnss, String rc, Date data_de_transaction, String codeF) {
        super(id, nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, ifi, ice, tp, cnss, rc, data_de_transaction);
        this.codeF = codeF;
    }

    public Fournisseur(String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, String ifi, String ice, String tp, String cnss, String rc, Date data_de_transaction, String codeF) {
        super(nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, ifi, ice, tp, cnss, rc, data_de_transaction);
        this.codeF = codeF;
    }

    public String getCodeF() {
        return codeF;
    }

    public void setCodeF(String codeF) {
        this.codeF = codeF;
    }

    public Set<BonAchat> getListBonAchat() {
        return listBonAchat;
    }

    @JsonIgnore
    public void setListBonAchat(Set<BonAchat> listBonAchat) {
        this.listBonAchat = listBonAchat;
    }


}
