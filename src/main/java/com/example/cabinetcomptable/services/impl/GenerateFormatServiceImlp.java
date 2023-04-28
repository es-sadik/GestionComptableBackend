package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.*;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.*;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class GenerateFormatServiceImlp implements GenerateFormatService {

    @Autowired
    private BonAchatRepository bonAchatRepository;

    @Autowired
    BonHonoraireRepository bonHonoraireRepository;

    @Autowired
    ReglementFournisseurRepository reglementFournisseurRepository;
    @Autowired
    ReglementClientRepository reglementClientRepository;

    @Autowired
    FactureRepository factureRepository;

    @Override
    public String formatCodeClient(long id) {
        return String.format("C-"+"%04d" , id);
    }

    @Override
    public String formatCodeFournisseur(long id) {
        return String.format("F-"+"%04d" , id);
    }

    @Override
    public String formatNextNumeroBonAchat(Date date) {

        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        BonAchat lastBonAchat = bonAchatRepository.selectLastBonAchat(date);


        if (lastBonAchat == null) {
            return "BA-"+yearMonth+"-"+ String.format("%04d" ,1 );
        }
        else{

            LocalDate oldDate;
            if( lastBonAchat.getDateBa().toString().contains("-") ){
                oldDate = LocalDate.parse( lastBonAchat.getDateBa().toString());

            }
            else{
                oldDate = lastBonAchat.getDateBa().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }

             if(newDate.getYear() == oldDate.getYear()){

                String lastIdString  = lastBonAchat.getBonANum();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "BA-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }
            else{
                return "BA-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }
        }

    }

    @Override
    public String formatCurrentNumeroBonAchat(long id_ba,Date date) {

        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        BonAchat currentBonAchat = bonAchatRepository.findById(id_ba).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this id :: " + id_ba));
        BonAchat lastBonAchat = bonAchatRepository.selectLastBonAchat(date);
        LocalDate oldDate;
        if( lastBonAchat.getDateBa().toString().contains("-") ){
            oldDate = LocalDate.parse( lastBonAchat.getDateBa().toString());

        }
        else{
            oldDate = lastBonAchat.getDateBa().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if(newDate.getYear() == oldDate.getYear()){

            String currentIdString  = currentBonAchat.getBonANum();
            int id = Integer.parseInt(currentIdString.substring(currentIdString.lastIndexOf("-") + 1));
            return "BA-"+yearMonth+"-"+ String.format("%04d" , id );
        }
        else{
            if(lastBonAchat == null){
                return "BA-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }else{
                String lastIdString  = lastBonAchat.getBonANum();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "BA-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }

        }


    }

    @Override
    public String formatCurrentNumeroBonHonoraire(long id_bh, Date date) {

        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        BonHonoraire currentBonHonoraire = bonHonoraireRepository.findById(id_bh).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this id :: " + id_bh));
        BonHonoraire lastBonHonoraire = bonHonoraireRepository.selectLastBonHonoraire(date);

        LocalDate oldDate;
        if( lastBonHonoraire.getDateBh().toString().contains("-") ){
            oldDate = LocalDate.parse( lastBonHonoraire.getDateBh().toString());

        }
        else{
            oldDate = lastBonHonoraire.getDateBh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if(newDate.getYear() == oldDate.getYear()){

            String currentIdString  = currentBonHonoraire.getBonHNum();
            int id = Integer.parseInt(currentIdString.substring(currentIdString.lastIndexOf("-") + 1));
            return "BA-"+yearMonth+"-"+ String.format("%04d" , id );
        }
        else{
            if(lastBonHonoraire == null){
                return "BA-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }else{
                String lastIdString  = lastBonHonoraire.getBonHNum();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "BA-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }

        }

    }

    @Override
    public String formatNextNumeroBonHonoraire(Date date) {
        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        BonHonoraire lastBonHonoraire = bonHonoraireRepository.selectLastBonHonoraire(date);

        if (lastBonHonoraire == null) {
            return "BH-"+yearMonth+"-"+ String.format("%04d" ,1 );
        }
        else{

            LocalDate oldDate;
            if( lastBonHonoraire.getDateBh().toString().contains("-") ){
                oldDate = LocalDate.parse( lastBonHonoraire.getDateBh().toString());

            }
            else{
                oldDate = lastBonHonoraire.getDateBh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }

            if(newDate.getYear() == oldDate.getYear()){

                String lastIdString  = lastBonHonoraire.getBonHNum();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "BH-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }
            else{
                return "BH-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }
        }
    }



    @Override
    public String formatNextNumeroFacture(Date date) {
        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        Facture lastFacture = factureRepository.selectLastFacture(date);

        if (lastFacture == null) {
            return "FA-"+yearMonth+"-"+ String.format("%04d" ,1 );
        }
        else{

            LocalDate oldDate;
            if( lastFacture.getDateFac().toString().contains("-") ){
                oldDate = LocalDate.parse( lastFacture.getDateFac().toString());

            }
            else{
                oldDate = lastFacture.getDateFac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }


            if(newDate.getYear() == oldDate.getYear()){

                String lastIdString  = lastFacture.getFacNum();
                System.out.println("lastIdString"+lastIdString);
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "FA-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }
            else{
                return "FA-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }
        }
    }


    @Override
    public String formatNextCodeReglementFournisseur(Date date) {
        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        ReglementFournisseur LastReglementFournisseur = reglementFournisseurRepository.selectLasReglementFournisseur(date);


        if (LastReglementFournisseur == null) {
            System.out.println("null");
            return "RF-"+yearMonth+"-"+ String.format("%04d" ,1 );
        }
        else{
            System.out.println("Notnull");

            LocalDate oldDate;
            if( LastReglementFournisseur.getDatePayment().toString().contains("-") ){

                oldDate = LocalDate.parse( LastReglementFournisseur.getDatePayment().toString());

            }
            else{
                oldDate = LastReglementFournisseur.getDatePayment().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }


            if(newDate.getYear() == oldDate.getYear()){

                String lastIdString  = LastReglementFournisseur.getCodeRF();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "RF-"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }
            else{
                return "RF-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }
        }

    }

    @Override
    public String formatNextCodeReglementClient(Date date){

        LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatYearMonth = DateTimeFormatter.ofPattern("yyMM");
        String yearMonth = newDate.format(formatYearMonth);
        ReglementClient LastReglementClient = reglementClientRepository.selectLasReglementClient(date);


        if (LastReglementClient == null) {
            System.out.println("null");
            return "RC-"+yearMonth+"-"+ String.format("%04d" ,1 );
        }
        else{
            System.out.println("Notnull");

            LocalDate oldDate;
            if( LastReglementClient.getDatePayment().toString().contains("-") ){
                oldDate = LocalDate.parse( LastReglementClient.getDatePayment().toString());

            }
            else{
                oldDate = LastReglementClient.getDatePayment().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }

            if(newDate.getYear() == oldDate.getYear()){

                String lastIdString  = LastReglementClient.getCodeRC();
                int id = Integer.parseInt(lastIdString.substring(lastIdString.lastIndexOf("-") + 1));
                return "RC"+yearMonth+"-"+ String.format("%04d" , id+1 );
            }
            else{
                return "RC-"+yearMonth+"-"+ String.format("%04d" ,1 );
            }
        }

    }


}
