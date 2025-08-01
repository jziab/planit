package com.descodeuses.planit.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.descodeuses.planit.dto.ActionDTO;


import com.descodeuses.planit.service.ActionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/action")
public class ActionController {

    private final ActionService service; 
    public ActionController(ActionService service) {
        this.service = service;
    }

      @GetMapping
    public ResponseEntity<List<ActionDTO>> getAll() {
        List<ActionDTO> action = service.getAllActions();
        return new ResponseEntity<>(action, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String Hello() {

        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(1);
        liste.add(2);
        liste.add(3);

        return "Hello !";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionDTO> actionPostgreSqlById(@PathVariable Long id){
        ActionDTO action = service.getActionbyId(id);
        return new ResponseEntity<ActionDTO>(action, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ActionDTO> createAction(@RequestBody ActionDTO requestDTO) {
        ActionDTO createdDTO = service.create(requestDTO);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActionDTO> updateAction(@PathVariable Long id, @RequestBody ActionDTO requestDTO) {
        ActionDTO updateDTO = service.update(id, requestDTO);
        return new ResponseEntity<>(updateDTO, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjEntity(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

