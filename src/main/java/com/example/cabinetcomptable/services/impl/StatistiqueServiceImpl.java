package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.repositories.*;
import com.example.cabinetcomptable.services.StatistiqueService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatistiqueServiceImpl implements StatistiqueService {

    @Autowired
    ClientRepository clientRepository ;

    @Autowired
    FournisseurRepository fournisseurRepository ;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    BonAchatRepository bonAchatRepository;

    @Autowired
    BonHonoraireRepository bonHonoraireRepository;

    @Autowired
    LignBARepository lignBARepository;

    @Autowired
    LignBHRepository lignBHRepository;

    @Autowired
    ReglementFournisseurRepository reglementFournisseurRepository;

    @Autowired
    ReglementClientRepository reglementClientRepository;

    @Autowired
    FactureRepository factureRepository;

    // For Cards
    @Override
    public Map<String,Long> countNumberOfAll(){
        Map<String,Long> map = new HashMap<String, Long>() ;

        map.put("client", clientRepository.count());
        map.put("fournisseur", fournisseurRepository.count());
        map.put("produit", produitRepository.count());
        map.put("categorie", categorieRepository.count());
        map.put("bonAchat", bonAchatRepository.count());
        map.put("bonHonoraire", bonHonoraireRepository.count());
        map.put("reglementClient", reglementClientRepository.count());
        map.put("reglementFournisseur", reglementFournisseurRepository.count());
        map.put("facture", factureRepository.count());
        return map;

    }

    // For Grouped Vertical Bar Chart
    @Override
    public String getDataDepenseAndRecettePerYear(){

        Date nextDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nextDate);
        c.add(Calendar.YEAR, -3);
        nextDate = c.getTime();


        JSONArray mainData = new JSONArray();


        for(int i=0;i<4;i++){



            JSONArray series = new JSONArray();


            Double totalDepens = reglementFournisseurRepository.selectSumOfDepensePerYear(nextDate);
            Double totalRecettes = reglementClientRepository.selectSumOfRecettePerYear(nextDate);

            if(totalDepens == null ){
                totalDepens = (double) 0;
            }

            if(totalRecettes == null){
                totalRecettes = (double) 0;
            }



            series.put( getColumn("Dépens", totalDepens ) );
            series.put( getColumn("Recettes", totalRecettes ) );


            mainData.put( getRow(c.get(Calendar.YEAR)+"" , series) );

            c.add(Calendar.YEAR, 1);
            nextDate = c.getTime();

            c.setTime(nextDate);
        }


        return mainData.toString();
    }



    // For Line Chart
    @Override
    public String getDataDepenseAndRecettePerMonth(){

        Date nextMonth = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nextMonth);
        c.add(Calendar.MONTH, -4);
        nextMonth  = c.getTime();


        JSONArray mainData = new JSONArray();
        JSONArray seriesDepens = new JSONArray();
        JSONArray serriesRecettes = new JSONArray();


        for (int i = 0; i < 5; i++) {

            Double totalDepens = reglementFournisseurRepository.selectSumOfDepensePerMonth(nextMonth);
            Double totalRecettes = reglementClientRepository.selectSumOfRecettePerMonth(nextMonth);
            System.out.println(nextMonth + " : "+ totalDepens  +" , " +totalRecettes);

            if (totalDepens == null) {
                totalDepens = (double) 0;
            }

            if (totalRecettes == null) {
                totalRecettes = (double) 0;
            }


            seriesDepens.put(getColumn( capitalize( c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE) ) , totalDepens));
            serriesRecettes.put(getColumn(capitalize( c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE) ) , totalRecettes));

            c.add(Calendar.MONTH, 1);
            nextMonth = c.getTime();
            c.setTime(nextMonth);

        }


        mainData.put( getRow( "Dépens", seriesDepens) );
        mainData.put( getRow("Recettes",serriesRecettes) );


        return mainData.toString();
    }


    @Override
    public String getDataTop5ProdduitByQuantiteDisponile(){

        JSONArray mainData = new JSONArray();
        List<Produit> produits = produitRepository.findTop5ByOrderByQuantitieDisponibleDesc() ;

        if(produits != null){
            for( Produit currentValue: produits){
                mainData.put( getColumn(currentValue.getDesignation(), (double) currentValue.getQuantitieDisponible()) );
            }
        }

        return mainData.toString() ;
    }


    @Override
    public String getDataTop5ByOrderByQuantitieOfLignBH(){



        JSONArray mainData = new JSONArray();
        List<String> designations = lignBHRepository.selectDesignationTop5ByOrderByQuantitieOfLignBH();
        List<String> sumQuantites = lignBHRepository.selectSumQuantiteTop5ByOrderByQuantitieOfLignBH();

        if(designations != null || sumQuantites != null){

            for(int i = 0; i < designations.size() || i < sumQuantites.size() ;i++){

                mainData.put( getColumn(designations.get(i), Double.parseDouble(sumQuantites.get(i)) ) );
            }
        }


        return mainData.toString() ;
    }




    JSONObject  getColumn(String name, Double value){

        JSONObject column = new JSONObject();
        column.put("name", name);
        column.put("value", value);
        return column ;
    }

    JSONObject  getRow(String name, JSONArray jsonArray){

        JSONObject row = new JSONObject();
        row.put("name", name);
        row.put("series", jsonArray);
        return row ;
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }




}
