package com.example.cabinetcomptable.entities.dto;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.entities.LignBH;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class BonHonoraireDto implements Serializable {

    private  long idBh;
    private  String bonHNum;
    private  Date dateBh;
    private  boolean valide;
    private  boolean status;
    private  double montantTotal;
    private  double montantPayer;
    private  Client client;
    private Set<LignBH> listLignBH;


}
