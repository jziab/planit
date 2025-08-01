package com.descodeuses.planit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.descodeuses.planit.dto.ProjetDTO;
import com.descodeuses.planit.entity.ProjetEntity;
import com.descodeuses.planit.repository.ProjetRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetService {
    private final ProjetRepository repository;
    public ProjetService(ProjetRepository repository){
        this.repository = repository;
    }

    private ProjetDTO convProjetDTO (ProjetEntity ProjetEntity) {
        return new ProjetDTO(
            ProjetEntity.getId(),
            ProjetEntity.getTitle(),
            ProjetEntity.getDescription(),
            ProjetEntity.isCompleted(),
            ProjetEntity.getDueDate(),
            ProjetEntity.getPriority(),
            ProjetEntity.getStatut()

            );

    }

    private ProjetEntity convProjetEntity(ProjetDTO projetDTO){
        ProjetEntity projetEntity = new ProjetEntity();
        projetEntity.setId(projetDTO.getId());
        projetEntity.setTitle(projetDTO.getTitle());
        projetEntity.setDescription(projetDTO.getDescription());
        projetEntity.setCompleted(projetDTO.isCompleted());
        projetEntity.setDueDate(projetDTO.getDueDate());
        projetEntity.setPriority(projetDTO.getPriority());
        projetEntity.setStatut(projetDTO.getStatut());

        return projetEntity;
    }
// Lire tout les projet // obtenir tout les projets 
    public List<ProjetDTO> getAllProjetDTOs(){
        List<ProjetEntity> projetEntities = repository.findAll();
        List<ProjetDTO>  projetDtoList = new ArrayList<>();

        for(ProjetEntity elem : projetEntities ){
            projetDtoList.add(convProjetDTO(elem));
        }

        return projetDtoList;
    }
//Obtenir un projet par id
    public ProjetDTO getProjetEntityByID(Long id){
        Optional<ProjetEntity> projet = repository.findById(id);

        if(projet.isEmpty()){
            throw new EntityNotFoundException("Projet not found with id: "+ id);
        }

        return convProjetDTO(projet.get());

    }
// create 
    public ProjetDTO create(ProjetDTO projetDTO){
        ProjetEntity projet = convProjetEntity(projetDTO);
        ProjetEntity savedProjetEntity = repository.save(projet);
        return convProjetDTO(savedProjetEntity);
    }
// update 
    public ProjetDTO updaProjetDTO(Long id, ProjetDTO dto){
        ProjetEntity projet = repository.findById(id)
            .orElseThrow( () -> new EntityNotFoundException("Projet not found with id: "+ id));
        projet.setTitle(dto.getTitle());
        projet.setDescription(dto.getDescription());
        projet.setCompleted(dto.isCompleted());
        projet.setDueDate(dto.getDueDate());
        projet.setPriority(dto.getPriority());
        projet.setStatut(dto.getStatut());
        
        ProjetEntity updated = repository.save(projet);
        return convProjetDTO(updated);
        
    }
//delete
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Projet not found with id : "+ id);
        }
        repository.deleteById(id);
    }

}
