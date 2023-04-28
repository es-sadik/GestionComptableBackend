package com.example.cabinetcomptable.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data

public class FournisseurDto implements Serializable {
    private  long id;
    private  String nom;
    private  String image;
    private  String email;
    private  String telePortable;
    private  String teleFix;
    private  String ville;
    private  String adresse;
    private  String codePostale;
    private  String siteWeb;
    private  String ifi;
    private  String ice;
    private  String tp;
    private  String cnss;
    private  String rc;
    private  Date dateTransaction;

    private  String codeF;
    private  Set<BonAchatDto> listBonAchat;

}
