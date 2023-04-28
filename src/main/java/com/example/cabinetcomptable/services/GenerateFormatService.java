package com.example.cabinetcomptable.services;

import java.util.Date;

public interface GenerateFormatService {
    String formatCodeClient(long id);
    String formatCodeFournisseur(long id);
    String formatNextNumeroBonAchat(Date date);
    String formatCurrentNumeroBonAchat(long id,Date date);
    String formatNextNumeroBonHonoraire(Date date);

    String formatNextNumeroFacture(Date date);

    String formatCurrentNumeroBonHonoraire (long id,Date date);

    String formatNextCodeReglementFournisseur(Date date);

    String formatNextCodeReglementClient(Date date);

}
