package com.descodeuses.planit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.descodeuses.planit.dto.ContactDTO;
import com.descodeuses.planit.entity.Contact;
import com.descodeuses.planit.repository.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    // Convertir l'entité vers DTO
    private ContactDTO convertToDTO(Contact contact) {
        return new ContactDTO(
            contact.getId(),
            contact.getNom(),
            contact.getPrenom(),
            contact.getAge()
        );
    }

    // Convertir DTO vers entité
    private Contact convertToEntity(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setId(contactDTO.getId());
        contact.setNom(contactDTO.getNom());
        contact.setPrenom(contactDTO.getPrenom());
        contact.setAge(contactDTO.getAge());
        return contact;
    }

    // Obtenir tous les contacts
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = repository.findAll();
        List<ContactDTO> contactDTOList = new ArrayList<>();

        for (Contact elem : contacts) {
            contactDTOList.add(convertToDTO(elem));
        }

        return contactDTOList;
    }

    // Obtenir un contact par ID
    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = repository.findById(id);

        if (contact.isEmpty()) {
            throw new EntityNotFoundException("Contact not found with id: " + id);
        }

        return convertToDTO(contact.get());
    }
// create contact
    public ContactDTO create(ContactDTO contactDTO) {
    Contact contact = convertToEntity(contactDTO);
    Contact savedContact = repository.save(contact);
    return convertToDTO(savedContact);
}
// update contact
public ContactDTO update(Long id, ContactDTO dto) {
    Contact contact = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Contact not found with id: " + id));

    // Mise à jour des champs
    contact.setNom(dto.getNom());
    contact.setPrenom(dto.getPrenom());
    contact.setAge(dto.getAge());

    Contact updated = repository.save(contact);
    return convertToDTO(updated);
}

//delete contact
public void delete(Long id) {
    if (!repository.existsById(id)) {
        throw new EntityNotFoundException("Contact not found with id: " + id);
    }
    repository.deleteById(id);
}

}

//public ActionDTO update(ActionDTO dto) {
        // Rechercher l'entité par son identifiant
        //entitéExistante = référentiel.trouverParId(id)
        //    sinon lever une exception "Ressource non trouvée"

        // Mettre à jour les champs de l'entité avec les valeurs du DTO
        //entitéExistante.titre = dto.titre
        //entitéExistante.completé = dto.estCompleté
        //entitéExistante.priorité = dto.priorité
        //entitéExistante.dateLimite = dto.dateLimite

        // Sauvegarder l'entité mise à jour dans la base de données
        //entitéMiseAJour = référentiel.sauvegarder(entitéExistante)

        // Convertir l'entité mise à jour en DTO et retourner
        //retourner convertirVersDTO(entitéMiseAJour)
    //}

    //public void delete(Long id) {
        // Vérifier si une entité avec l'identifiant donné existe
        //si référentiel.n'existePasParId(id) alors
        //   lever une exception "Ressource non trouvée avec cet id"

        // Supprimer l'entité par son identifiant
        //référentiel.supprimerParId(id)
    //}