package com.descodeuses.planit.test;

class Apprenante{
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String prenom;
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


}

public class TestJava {

    public static void main(String[]arg){
        int somme =1+1;
        System.out.println("Resultat : "+somme);
        Apprenante descodeuses = new Apprenante();
        descodeuses.setPrenom("Sophie");
        descodeuses.setAge(24);
        System.out.println("Le nom est : "+descodeuses.getPrenom());// console.log de java
        System.out.println("L'age est :"+descodeuses.getAge());
        System.out.println("--------------------------------------------");

    }

  
}
