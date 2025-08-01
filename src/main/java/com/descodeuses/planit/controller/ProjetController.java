package com.descodeuses.planit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.descodeuses.planit.dto.ProjetDTO;
import com.descodeuses.planit.service.ProjetService;

@RestController
@RequestMapping("/api/projet")
public class ProjetController {
    private final ProjetService service;
    public ProjetController(ProjetService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProjetDTO>> getAll(){
        List<ProjetDTO> projetDTOs = service.getAllProjetDTOs();
        return new ResponseEntity<>(projetDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDTO>getById(@PathVariable Long id){
        ProjetDTO projet = service.getProjetEntityByID(id);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjetDTO> create(@RequestBody ProjetDTO projetDTO) {
        ProjetDTO savProjetDTO = service.create(projetDTO);
        return new ResponseEntity<>(savProjetDTO, HttpStatus.CREATED);
    }
        
    @PutMapping("/{id}")
    public ResponseEntity<ProjetDTO>  updateProjEntity(@PathVariable Long id, @RequestBody ProjetDTO projetDTO) {
        System.out.println("-----id-----------"+id);
        ProjetDTO updated = service.updaProjetDTO(id, projetDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjEntity(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}