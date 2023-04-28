package com.example.cabinetcomptable.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReglementFournisseurDto implements Serializable {
    private  long idRegF;
    private  String codeRF;
    private  String modePaymant;
    private  boolean status;
    private  double avance;
    private  double reste;
    private  Date datePayment;
    private  BonAchatDto bonAchat;
}
