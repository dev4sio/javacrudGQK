/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrud.view;

import java.util.HashMap;
import javacrud.gestUtil.Commune;
import javacrud.model.Utilisateur;

/**
 *
 * @author g.gerbaud
 */
public interface VilleDAO {
    
    public HashMap<Integer, Commune> list(String codePostal);
    
}
