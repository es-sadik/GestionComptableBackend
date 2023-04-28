package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.services.StatistiqueService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/statistiques")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StatistiqueController {

    @Autowired
    StatistiqueService statistiqueService;

    @GetMapping("/getNumbersOfAll")
    public ResponseEntity< Map<String,Long> > getNumbersOfAll(){
        return ResponseEntity.ok(statistiqueService.countNumberOfAll());

    }

    @GetMapping("/dataBarChart")
    public ResponseEntity<String>  getDataBarChart(){
        return ResponseEntity.ok( statistiqueService.getDataDepenseAndRecettePerYear() );
    }

    @GetMapping("/dataLineChart")
    public ResponseEntity<String>  getDataLineChart(){
        return ResponseEntity.ok( statistiqueService.getDataDepenseAndRecettePerMonth() );
    }

    @GetMapping("/dataPieChart")
    public ResponseEntity<String>  getDataPieChart(){
        return ResponseEntity.ok( statistiqueService.getDataTop5ProdduitByQuantiteDisponile() );
    }

    @GetMapping("/dataDoughnutChart")
    public ResponseEntity<String>  getDataDoughnutChart(){
        return ResponseEntity.ok( statistiqueService.getDataTop5ByOrderByQuantitieOfLignBH() );
    }


}
