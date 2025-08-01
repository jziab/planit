package com.descodeuses.planit.dto;

import java.time.LocalDate;



public class ActionDTO {

     private Long id;
    private String title;
    private boolean completed;
    private LocalDate duDate;

       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

     public ActionDTO(Long id, String title, LocalDate duDate) {
        this.id = id;
        this.title = title;
        this.duDate = duDate;
    }

 


}
