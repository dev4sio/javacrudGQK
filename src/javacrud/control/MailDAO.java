/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import java.util.Arrays;
import javacrud.tech.UtilDB;
import javax.mail.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Guilhem
 */
public class MailDAO {
     public void insert(Message unMail) throws Exception{
        
//        try {
//            Connection con = UtilDB.getConnect();
//            String sql = "INSERT INTO utilisateur (ut_pseudo, ut_nom, ut_prenom, ut_mp, ut_mail, ut_phrase, ut_adr1, ut_adr2, ut_cdpost, ut_numpost) VALUES (?,?,?,?,?,?,?,?,?,?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, utilisateur.getUtPseudo());
//            ps.setString(2, utilisateur.getUtNom());
//            ps.setString(3, utilisateur.getUtPrenom());
//            ps.setString(4, utilisateur.getUtMp());
//            ps.setString(5, utilisateur.getUtMail());
//            ps.setString(6, utilisateur.getUtPhrase());
//            ps.setString(7, utilisateur.getUtAdr1());
//            ps.setString(8, utilisateur.getUtAdr2());
//            ps.setString(9, utilisateur.getUtCdpost());
//            ps.setString(10, utilisateur.getUtNumpost());
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "DB : Enregistrement créé !");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la création de l'utilisateur");
//        }
    }
}
