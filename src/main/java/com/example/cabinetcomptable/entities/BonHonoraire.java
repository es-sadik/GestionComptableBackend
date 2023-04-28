package com.example.cabinetcomptable.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "bon_honoraire")
public class BonHonoraire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBh;

    @Column(unique = true)
    private String bonHNum;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateBh;

    private  boolean valide;
    private  boolean status;

    private double montantTotal;

    private double montantPayer;

    @ManyToOne
    @JoinColumn( name = "id_c" )
    private Client client;

    @OneToOne(mappedBy = "bonHonoraire")
    private Facture facture;

    @OneToMany(mappedBy = "bonHonoraire",cascade = CascadeType.ALL)
    private Set<ReglementClient> listReglementClient = new HashSet<ReglementClient>();

    @OneToMany(mappedBy = "bonHonoraire",cascade = CascadeType.ALL)
    private Set<LignBH>  listLignBH= new HashSet<LignBH>();



    public BonHonoraire() {
    }

    public BonHonoraire(long idBh, String bonHNum, Date dateBh, boolean valide, boolean status, double montantTotal, double montantPayer) {
        this.idBh = idBh;
        this.bonHNum = bonHNum;
        this.dateBh = dateBh;
        this.valide = valide;
        this.status = status;
        this.montantTotal = montantTotal;
        this.montantPayer = montantPayer;
    }

    public BonHonoraire(String bonHNum, Date dateBh, boolean valide, boolean status, double montantTotal, double montantPayer) {
        this.bonHNum = bonHNum;
        this.dateBh = dateBh;
        this.valide = valide;
        this.status = status;
        this.montantTotal = montantTotal;
        this.montantPayer = montantPayer;
    }

    public long getIdBh() {
        return idBh;
    }

    public void setIdBh(long idBh) {
        this.idBh = idBh;
    }

    public String getBonHNum() {
        return bonHNum;
    }

    public void setBonHNum(String bonHNum) {
        this.bonHNum = bonHNum;
    }

    public Date getDateBh() {
        return dateBh;
    }

    public void setDateBh(Date dateBh) {
        this.dateBh = dateBh;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Set<ReglementClient> getListReglementClient() {
        return listReglementClient;
    }

    public void setListReglementClient(Set<ReglementClient> listReglementClient) {
        this.listReglementClient = listReglementClient;
    }

    public Set<LignBH> getListLignBH() {
        return listLignBH;
    }

    public void setListLignBH(Set<LignBH> listLignBH) {
        this.listLignBH = listLignBH;
    }
}
