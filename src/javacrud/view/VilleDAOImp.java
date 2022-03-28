/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javacrud.gestUtil.Commune;
import javacrud.model.Utilisateur;
import javacrud.tech.UtilDB;
import javax.swing.JOptionPane;

/**
 *
 * @author g.gerbaud
 */
public class VilleDAOImp implements VilleDAO {
    
    public VilleDAOImp() {
        
    }

    @Override
    public HashMap<Integer, Commune> list(String codePostal) {
        HashMap<Integer, Commune> list = new HashMap<>();
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM `codes_postaux` WHERE `Code_Postal` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codePostal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Commune c = new Commune(rs.getString("Code_Postal"),rs.getString("Num_Postal"),rs.getString("Nom_Commune"));
                list.put(rs.getInt("Num_Postal"), c);
            }
            
            
            JOptionPane.showMessageDialog(null, "DB : Liste des villes affichées !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : La liste des villes n'a pa pu s'afficher");
        }
        return list;
    }


    
}
