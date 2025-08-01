package com.descodeuses.planit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.descodeuses.planit.dto.ContactDTO;
import com.descodeuses.planit.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService service;
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Contact!";
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAll() {
        List<ContactDTO> contacts = service.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getById(@PathVariable Long id) {
        ContactDTO contact = service.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

   
   @PostMapping
    public ResponseEntity<ContactDTO> create(@RequestBody ContactDTO contactDTO) {
    ContactDTO savedContact = service.create(contactDTO);
    return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
}

   @PatchMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        ContactDTO updated = service.update(id, contactDTO);
        return ResponseEntity.ok(updated);
    }

     // DELETE contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
