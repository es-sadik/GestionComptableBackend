package com.example.cabinetcomptable.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FactureDto implements Serializable {
    private long idFac;
    private String facNum;
    private Date dateFac;
    private double totalHt;
    private double totalTva;
    private double totalTtc;
    private BonHonoraireDto bonHonoraire;
}
