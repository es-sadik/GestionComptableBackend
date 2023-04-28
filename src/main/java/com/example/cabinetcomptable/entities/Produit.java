package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {
    
    @Id
    private String reference;
    private String image;
    private String designation;
    private String description;
    private String type;
    private String marque;
    private double longueur;
    private double largeur;
    private double hauteur;
    private double poids;
    private double surface;
    private double volume;
    private double prixAchat;
    private double prixVente;
    private double prixRevient;
    private double tva;
    private int quantitieDisponible;
    
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Categorie categorie ;
    
    @OneToMany(mappedBy = "produit")
    private Set<LignBA> ListLignBA = new HashSet<LignBA>();

    @OneToMany(mappedBy = "produit")
    private Set<LignBH> ListLignBH = new HashSet<LignBH>();

    public Produit() {
    }

    public Produit(String reference, String image, String designation, String description, String type, String marque, double longueur, double largeur, double hauteur, double poids, double surface, double volume, double prixAchat, double prixVente, double prixRevient, double tva, int quantitieDisponible) {
        this.reference = reference;
        this.image = image;
        this.designation = designation;
        this.description = description;
        this.type = type;
        this.marque = marque;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.poids = poids;
        this.surface = surface;
        this.volume = volume;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.prixRevient = prixRevient;
        this.tva = tva;
        this.quantitieDisponible = quantitieDisponible;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public int getQuantitieDisponible() {
        return quantitieDisponible;
    }

    public void setQuantitieDisponible(int quantitieDisponible) {
        this.quantitieDisponible = quantitieDisponible;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    //@JsonIgnore
    public Categorie getCategorie() {
        return categorie;
    }

    @JsonIgnore
    public Set<LignBA> getListLignBA() {
        return ListLignBA;
    }

    public void setListLignBA(Set<LignBA> listLignBA) {
        ListLignBA = listLignBA;
    }

    @JsonIgnore
    public Set<LignBH> getListLignBH() {
        return ListLignBH;
    }

    public void setListLignBH(Set<LignBH> listLignBH) {
        ListLignBH = listLignBH;
    }
}
