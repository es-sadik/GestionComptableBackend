package com.example.cabinetcomptable.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
@DiscriminatorColumn(name = "PersonneType")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @NotBlank
    @NotNull
    private String nom;
    private String image;

    private String email;
    private String telePortable;
    private String teleFix;
    private String ville;
    private String adresse;
    private String codePostale;
    private String siteWeb;
    private String ifi ;
    private String ice;
    private String tp;
    private String cnss;
    private String rc;
    @CreatedDate
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;


    public Personne() {
    }

    public Personne(long id, String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.telePortable = telePortable;
        this.teleFix = teleFix;
        this.ville = ville;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.siteWeb = siteWeb;
        this.ifi = ifi;
        this.ice = ice;
        this.tp = tp;
        this.cnss = cnss;
        this.rc = rc;
        this.dateTransaction = dateTransaction;
    }

    public Personne(String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction) {
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.telePortable = telePortable;
        this.teleFix = teleFix;
        this.ville = ville;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.siteWeb = siteWeb;
        this.ifi = ifi;
        this.ice = ice;
        this.tp = tp;
        this.cnss = cnss;
        this.rc = rc;
        this.dateTransaction = dateTransaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelePortable() {
        return telePortable;
    }

    public void setTelePortable(String telePortable) {
        this.telePortable = telePortable;
    }

    public String getTeleFix() {
        return teleFix;
    }

    public void setTeleFix(String teleFix) {
        this.teleFix = teleFix;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getIfi() {
        return ifi;
    }

    public void setIfi(String ifi) {
        this.ifi = ifi;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
