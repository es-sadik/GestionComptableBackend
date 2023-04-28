package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBA;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface LignBARepository extends JpaRepository<LignBA,Long> {



}

