package com.descodeuses.planit.exerciceTp;

import java.util.ArrayList;
import java.util.Scanner;
 

class Taches{
    public String nom ;

    public String getNom() {
        return nom;
    }

    public void setNom(String taches) {
        this.nom = taches;
    }
    public Boolean completed;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}

public class exercice1 {

     public static void main(String[]arg){
        
        ArrayList<Taches> tacheslist = new ArrayList<>();//creation d'un tableau pour ajouter des taches .
        Scanner scanner = new Scanner(System.in); //entrer clavier  la tache
        boolean continuer = true;
        while (continuer) {
            System.out.println("**MENU DES TACHES**");// afficher la tache 
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Voir les tâches");
            System.out.println("3. Mentionnez une tâche comme faites");
        
            
            int choix = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Votre choix:  "+ choix);
        

            if (choix == 1){
                System.out.println("Entrer la nouvelle tâche : ");
                String nouvelleTache = scanner.nextLine();
                Taches tache = new Taches();
                tache.setNom(nouvelleTache);
               // System.out.println(tache.getTaches());
                tacheslist.add(tache);
                System.out.println("Tâche ajoutée !");
                ///////////////////////////////////////////////////////////////
            }  else if (choix == 2){
                System.out.println("Listes des tâches : ");
                if (tacheslist.isEmpty() ){
                    System.out.println("Aucune tâche est trouvée!");
                } 
            
                tacheslist.forEach((n)-> { System.out.println(n.getNom()+" completed: "+n.getCompleted());} );

            } else if (choix == 3 ){
                if (tacheslist.isEmpty() ){
                    System.out.println("Aucune tâche à mentionnez!");
                }else {
                    System.out.println("Quelle tâche voulez-vous mentionnez comme faite ?");
                    
                    tacheslist.forEach((n)-> { System.out.println(n.getNom());} );
                    // for (int i = 0; i < tacheslist.size(); i++) {
                    //     System.out.println(tacheslist.get(i));
                    // }
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    if (numero > 0 && numero <= tacheslist.size() ) {
                        tacheslist.get(numero).setCompleted(true);
                        System.out.println("Tâche marquée comme faite !");
                    } else {
                        System.out.println("Tâche non completed !");
                    }
                }

            }
  
 
        }
    }
}
