package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClientService {
    ResponseEntity<Client> addClient(Client client) ;
    ResponseEntity<Client> getClient(long id);
    List<Client> getAllClients();
    ResponseEntity<Client> updateClient(long id, Client client);
    String getFile();
    void addFile(MultipartFile file);
    boolean deleteClient(long id);


    }
