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
public class Kaffee extends Vorrat{
    
    public Kaffee(int nummer, String name, int anzahl, double preis) {
        super(nummer, name, anzahl, preis);
    }

    @Override
    public String toString() {
        String f1=super.toString();
        return f1;
    }
    
}
