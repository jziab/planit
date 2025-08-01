package com.descodeuses.planit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.descodeuses.planit.dto.ActionDTO;

import com.descodeuses.planit.entity.Action;

import com.descodeuses.planit.repository.ActionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ActionService {
    private final ActionRepository repository;

    public ActionService(ActionRepository repository){
        this.repository = repository;
    }

    private ActionDTO convertToDTO(Action action){
        return new ActionDTO(

            action.getId(),
            action.getTitle(),
            action.getDuDate()
            );

    }
   private Action converttoEntity(ActionDTO actionDTO){
    Action action = new Action();
    action.setId(actionDTO.getId());
    action.setTitle(actionDTO.getTitle());
    action.setDuDate(actionDTO.getDuDate());

    return action;
   }

   public List<ActionDTO> getAllActions(){
        List<Action> actions = repository.findAll();
        //Declarer une variable liste de action DTO
        List<ActionDTO> actionDTOList = new ArrayList<>();
        //Faire boucle sur la liste action
        for (Action elem : actions) {
            //Convertir action vers action dto
            //Ajouter action dto dans la liste
            actionDTOList.add(convertToDTO(elem));
        }
        // Retourner la liste
        return actionDTOList;
    }

    public ActionDTO getActionbyId(Long id){
       //Version courte
        /*
        Action action = 
            repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Action not found with id: " + id));

        return convertToDTO(action);
        */
        
        Optional<Action> action = repository.findById(id);
        
        if(action.isEmpty()) {
            throw new EntityNotFoundException("Action not found with id: " + id);
        }

        return convertToDTO(action.get());
    }

        public ActionDTO create(ActionDTO actionDTO) {
    Action action = converttoEntity(actionDTO);
     Action savedContact = repository.save(action);
    return convertToDTO(savedContact);
}

    //Update
public ActionDTO update(Long id, ActionDTO actionDTO) {

    System.out.println("-----------"+id);
        Action existingContact = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact non trouvé avec id: " + id));

        // existingContact.setId(actionDTO.getId());
        existingContact.setTitle(actionDTO.getTitle());
        existingContact.setDuDate(actionDTO.getDuDate());
      

        Action updatedContact = repository.save(existingContact);
        return convertToDTO(updatedContact);
    } 


//Delete
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contact non trouvé avec id: " + id);
        }
        repository.deleteById(id);
    }
}
