package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;



@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    ServletContext context;

    // get client :
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id) {
        return clientService.getClient(id);
    }

    // get clients :
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    // add Client :
    @PostMapping( "/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return  clientService.addClient(client);
    }

    // update client :
    @PutMapping("/clients/{id}")
    public void updateClient(@PathVariable long id, @RequestBody Client client) {
        clientService.updateClient(id,client);
    }

    // delete client :
    @DeleteMapping("clients/{id}")
    public boolean deleteClient(@PathVariable long id){
        return clientService.deleteClient(id);
    }

    @GetMapping("/imageclient")
    public ResponseEntity<String> getImage(){
        return ResponseEntity.ok(clientService.getFile());
    }

    @PutMapping("/imageclient")
    public void addFile(@RequestParam("file") MultipartFile file) {
        clientService.addFile(file);
    }





}
