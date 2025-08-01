package com.descodeuses.planit.controller;


import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.descodeuses.planit.entity.Action;


@RestController
@RequestMapping("/api/utilisateur")
public class utilisateurController {
    @GetMapping("/hello")
    public String Hello() {

        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(1);
        liste.add(2);
        liste.add(3);

        return "Hello !";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getById() {
     Action action = new Action();

        action.setTitle("Enovyer un mail");
        return new ResponseEntity<>(action, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Action>> getAll() {
        Action action1 = new Action();
        action1.setTitle("Enovyer un mail");

        Action action2 = new Action();
        action2.setTitle("Appel telephoniquel");

        ArrayList<Action> list = new ArrayList<>();
        list.add(action1);
        list.add(action2);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public String create() {        
        return "create";
    }

    @PatchMapping
    public String update() {
        return "update";
    }

    @DeleteMapping
    public String delete() {
        return "delete";
    }

}
