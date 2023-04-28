package com.example.cabinetcomptable.entities.dto;

import com.example.cabinetcomptable.entities.Fournisseur;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BonAchatDto implements Serializable {
    private  long idBa;
    private  String bonANum;
    private  String facBonNum;
    private  Date dateBa;
    private  boolean status;
    private  double montantTotal;
    private  double montantPayer;
    private  Fournisseur fournisseur;
}
