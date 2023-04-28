package com.example.cabinetcomptable.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReglementClientDto implements Serializable {
    private  long idRegC;
    private  String codeRC;
    private  String modePaymant;
    private  boolean status;
    private  double avance;
    private  double reste;
    private  Date datePayment;
    private  BonHonoraireDto bonHonoraire;
}
