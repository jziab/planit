package com.descodeuses.planit.dto;

public class SignupRequestDTO {
    private String username;
    
    private String password;
    
    private String nom;
   
    private String prenom;
  
    private String genre;
  
    private String email;

 
   ///Getters et setteres///
   public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
     public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
      public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
      public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
