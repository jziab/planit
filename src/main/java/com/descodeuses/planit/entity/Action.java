package com.descodeuses.planit.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private boolean completed;
    private LocalDate duDate;
 @ManyToMany
    @JoinTable(
        name = "todo_contact",
        joinColumns = @JoinColumn(name = "todo_id"),
        inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    
    private Set<Contact> members = new HashSet<>();

    public Set<Contact> getMembers() {
        return members;
    }

    public void setMembers(Set<Contact> members) {
        this.members = members;
    }

    @ManyToOne 
@JoinColumn(name="projet_id",
    referencedColumnName="id")
    private ProjetEntity projet;
    public ProjetEntity getProjet(){
        return projet;
    }
public void setProjet(ProjetEntity projet){
    this.projet=projet;

}
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

   

    public LocalDate getDuDate() {
        return duDate;
    }

    public void setDuDate(LocalDate duDate) {
        this.duDate = duDate;
    }

    public Action() {
        // Constructeur vide obligatoire pour Spring (Jackson)
    }

    public Action(Long id, String title) {
        this.id = id;
        this.title = title;
    }

 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getPriority() {

        throw new UnsupportedOperationException("Unimplemented method 'getPriority'");
    }

    public Object getDescription() {

        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

 
}



