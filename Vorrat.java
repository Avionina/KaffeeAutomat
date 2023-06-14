/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_kaffeeautomat;

/**
 *
 * @author MMoschkau
 */
public class Vorrat {
     private int nummer;
     private String name;
     private int anzahl;
     private double preis;
     
     public Vorrat (int nummer, String name, int anzahl, double preis){
         this.nummer = nummer;
         this.name=name;
         this.anzahl=anzahl;
         this.preis=preis;
              }
     
     public void setNummer(int nummer){
         this.nummer=nummer;
     }
     public int getNummer(){
         return nummer;
     }
     public void setName(String name){
         this.name=name;
     }
     public String getName(){
         return name;
     }
     public void setAnzahl(int anzahl){
         this.anzahl=anzahl;
     }
     public int getAnzahl(){
         return anzahl;
     }
     public void setPreis(double preis){
         this.preis=preis;
     }
     public double getPreis(){
         return preis;
     }
     @Override 
     public String toString(){
         return String.format("Nummer:\t%d\nName:\t%s\nAnzahl:\t%d\nPreis:\t%.2f\n",nummer,name,anzahl,preis);
     }
}
