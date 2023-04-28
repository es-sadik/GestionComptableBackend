package com.example.cabinetcomptable.services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public interface StatistiqueService {


    Map<String,Long> countNumberOfAll();

    String getDataDepenseAndRecettePerYear();

    String getDataDepenseAndRecettePerMonth();

    String getDataTop5ProdduitByQuantiteDisponile();

    String getDataTop5ByOrderByQuantitieOfLignBH();
}
