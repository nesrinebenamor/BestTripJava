/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esprit
 */
public class Utilisateur {
    
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private int age;
    private String login;
    private String password;
    private String image;
    private List<Recommandation> mesRecommandations;
    
    public Utilisateur(){}
    
    public Utilisateur(int id,String nom,String prenom,String mail,String login,String password,int age)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.age=age;
        this.login=login;
        this.password=password;
        this.id=id;
        mesRecommandations=new ArrayList<Recommandation>();
    }

    public Utilisateur(int id, String nom, String prenom, String mail, String login, String password, int age, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.age = age;
        this.login = login;
        this.password = password;
        this.image = image;
    }
    
    public Utilisateur(String nom,String prenom,String mail,String login,String password,int age)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.age=age;
        this.login=login;
        this.password=password;
        mesRecommandations=new ArrayList<Recommandation>();
    }
    
     public Utilisateur(String nom,String prenom,String mail,String login,String password,int age,String image)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.age=age;
        this.login=login;
        this.password=password;
        mesRecommandations=new ArrayList<Recommandation>();
        this.image=image;
    }

    public Utilisateur(String nom, String prenom, String mail, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.age = age;
        mesRecommandations=new ArrayList<Recommandation>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Recommandation> getMesRecommandations() {
        return mesRecommandations;
    }

    public void setMesRecommandations(List<Recommandation> mesRecommandations) {
        this.mesRecommandations = mesRecommandations;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        /*String mesrecommandation="";
        for(int i=0;i<mesRecommandations.size();i++)
        {
            mesrecommandation+=mesRecommandations.get(i);
        }*/
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", login=" + login +", Mot de passe=" + password + ", age=" + age + '}'+ "La liste des recommandation est  "+" \n ";
    }
    
    
    
    
}
