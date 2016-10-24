
package edu.esprit.dao.entities;


public class Guide {
    private String nom;
    private String resume;
    private float prix;
    Utilisateur utilisateur;
    
     public Guide(){};

    @Override
    public String toString() {
        return "guide{" + "nom=" + nom + ", resume=" + resume + ", prix=" + prix + '}';
    }
     

    public Guide(String nom, String resume, float prix,  Utilisateur utilisateur) {
        this.nom = nom;
        this.resume = resume;
        this.prix = prix;
        this.utilisateur=utilisateur;
        
    }
     public Guide(int id,String nom, String resume, float prix, Utilisateur utilisateur) {
        this.nom = nom;
        this.resume = resume;
        this.prix = prix;
        this.utilisateur=utilisateur;
        
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

   

    public String getNom() {
        return nom;
    }

    public String getResume() {
        return resume;
    }

    public float getPrix() {
        return prix;
    }

    
    
}
