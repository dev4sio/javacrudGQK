/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrud.control;

import java.util.HashMap;
import javacrud.model.Commune;
import javacrud.model.Utilisateur;

/**
 *
 * @author g.gerbaud
 */
public interface VilleDAO {
    
    public HashMap<Integer, Commune> villesPourCp(String codePostal);
    
}
