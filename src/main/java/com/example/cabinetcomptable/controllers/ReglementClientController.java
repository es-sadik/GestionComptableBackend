package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.ReglementClient;
import com.example.cabinetcomptable.entities.dto.ReglementClientDto;
import com.example.cabinetcomptable.services.ReglementClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReglementClientController {


    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    private ReglementClientService reglementClientService;


    // get ReglementClient :

    @PostMapping("/reglementClients/next")
    public ResponseEntity<String> getNextCodeRF(@RequestBody Date date){
        return ResponseEntity.ok(reglementClientService.getNextCodeReglementClient(date));
    }

    @GetMapping("reglementClients/{id_reg_c}")
    public ResponseEntity<ReglementClient> getReglementClient(@PathVariable long id_reg_c){
        return reglementClientService.getReglementClient(id_reg_c);
    }

    // get BonARegs :

    @GetMapping("reglementClients")
    public List<ReglementClientDto> getAllReglementClients(){

        List<ReglementClientDto> ListReglementClientDto = reglementClientService.getAllReglementClients().stream().map(r -> modelMapper.map(r, ReglementClientDto.class)).collect(Collectors.toList());

        return ListReglementClientDto;
    }

    // add ReglementClient :
    @PostMapping("reglementClients")
    public ResponseEntity<ReglementClient> addReglementClient(@RequestBody ReglementClientDto reglementClientDto){
        ReglementClient reglementClient = modelMapper.map(reglementClientDto, ReglementClient.class);

        return  reglementClientService.addReglementClient(reglementClient);
    }

    @PostMapping("reglementClients/addList")
    public ResponseEntity<List<ReglementClient>> addListReglementClient(@RequestBody List<ReglementClientDto> listReglementClientDto){

        List<ReglementClient> listReglementClient = listReglementClientDto.stream().map(r -> modelMapper.map(r, ReglementClient.class)).collect(Collectors.toList());

        return ResponseEntity.ok( reglementClientService.addListReglementClient(listReglementClient) );
    }

    // update ReglementClient :
    @PutMapping("/reglementClients/{id_reg_c}")
    public void updateReglementClient(@PathVariable long id_reg_c , @RequestBody ReglementClient reglementClient){
        reglementClientService.updateReglementClient(id_reg_c,reglementClient);
    }

    // Delete ReglementClient  :
    @DeleteMapping("/reglementClients/{id_reg_c}")
    public  void deleteReglementClient(@PathVariable long id_reg_c){
        reglementClientService.deleteReglementClient(id_reg_c);
    }

}
