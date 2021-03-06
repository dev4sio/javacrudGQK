/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import javacrud.model.Utilisateur;
import javacrud.tech.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author g.gerbaud
 */
public class UtilisateurDAOImp implements UtilDAO {

    @Override
    public void create(Utilisateur utilisateur) {

        try {
            Connection con = UtilDB.getConnect();
            String sql = "INSERT INTO utilisateur (ut_pseudo, ut_nom, ut_prenom, ut_mp, ut_mail, ut_phrase, ut_adr1, ut_adr2, ut_cdpost, ut_numpost) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, utilisateur.getUtPseudo());
            ps.setString(2, utilisateur.getUtNom());
            ps.setString(3, utilisateur.getUtPrenom());
            ps.setString(4, utilisateur.getUtMp());
            ps.setString(5, utilisateur.getUtMail());
            ps.setString(6, utilisateur.getUtPhrase());
            ps.setString(7, utilisateur.getUtAdr1());
            ps.setString(8, utilisateur.getUtAdr2());
            ps.setString(9, utilisateur.getUtCdpost());
            ps.setString(10, utilisateur.getUtNumpost());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement créé !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la création de l'utilisateur");
        }

    }

    @Override
    public void update(Utilisateur utilisateur) {
        try {
            Connection con = UtilDB.getConnect();
            String sql = 
                    "UPDATE utilisateur"
                    + " SET ut_pseudo = ?, ut_nom = ?, ut_prenom = ?, ut_mp = ?, ut_mail = ?, ut_phrase = ?, ut_adr1 = ?, ut_adr2 = ?, ut_cdpost = ?, ut_numpost = ?"
                    + " WHERE ut_pseudo = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, utilisateur.getUtPseudo());
            ps.setString(2, utilisateur.getUtNom());
            ps.setString(3, utilisateur.getUtPrenom());
            ps.setString(4, utilisateur.getUtMp());
            ps.setString(5, utilisateur.getUtMail());
            ps.setString(6, utilisateur.getUtPhrase());
            ps.setString(7, utilisateur.getUtAdr1());
            ps.setString(8, utilisateur.getUtAdr2());
            ps.setString(9, utilisateur.getUtCdpost());
            ps.setString(10, utilisateur.getUtNumpost());
            ps.setString(11, utilisateur.getUtPseudo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement modifié !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la modification de l'utilisateur");
        }
        
    }

    @Override
    public void delete(String pseudo) {
        try {
            Connection con = UtilDB.getConnect();
            String sql = "DELETE FROM utilisateur WHERE ut_pseudo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pseudo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement supprimé !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la suppression de l'utilisateur");
        }
    }

    @Override
    public Utilisateur get(String pseudo) {
        Utilisateur ut = new Utilisateur();
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT ut_pseudo, ut_nom, ut_prenom, ut_mp, ut_mail, ut_phrase, ut_adr1, ut_adr2, ut_cdpost, ut_numpost FROM utilisateur WHERE ut_pseudo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pseudo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            ut.setUtPseudo(rs.getString("ut_pseudo"));
            ut.setUtNom(rs.getString("ut_nom"));
            ut.setUtPrenom(rs.getString("ut_prenom"));
            ut.setUtMp(rs.getString("ut_mp"));
            ut.setUtMail(rs.getString("ut_mail"));
            ut.setUtPhrase(rs.getString("ut_phrase"));
            ut.setUtAdr1(rs.getString("ut_adr1"));
            ut.setUtAdr2(rs.getString("ut_adr2"));
            ut.setUtCdpost(rs.getString("ut_cdpost"));
            ut.setUtNumpost(rs.getString("ut_numpost"));
          
            JOptionPane.showMessageDialog(null, "DB : Utilisateur trouvé ! ");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur, Utilisataeur introuvable");
        }
        
        return ut; 
    }
    public boolean connexion(String pseudo, String password) {
        boolean userNpassMatch = false;
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder (BCryptPasswordEncoder.BCryptVersion.$2A, 12);
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM utilisateur WHERE ut_pseudo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pseudo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(null, "DB : Utilisateur trouvé :");
            if(bcrypt.matches(password, rs.getString("ut_phrase"))){
                userNpassMatch = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur, Utilisateur introuvable");
        }
        


        
        return userNpassMatch;
    }
    

    @Override
    public TreeMap<String, Utilisateur> list() {
        TreeMap<String, Utilisateur> list = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM util_vue ORDER BY ut_pseudo;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Utilisateur ut = new Utilisateur();
                ut.setUtPseudo(rs.getString("ut_pseudo"));
                ut.setUtNom(rs.getString("ut_nom"));
                ut.setUtPrenom(rs.getString("ut_prenom"));
                ut.setUtMp(rs.getString("ut_mp"));
                ut.setUtMail(rs.getString("ut_mail"));
                ut.setUtPhrase(rs.getString("ut_phrase"));
                ut.setUtAdr1(rs.getString("ut_adr1"));
                ut.setUtAdr2(rs.getString("ut_adr2"));
                ut.setUtCdpost(rs.getString("ut_cdpost"));
                ut.setUtNumpost(rs.getString("ut_numpost"));
                ut.setUtCommune(rs.getString("Nom_Commune"));

                list.put(ut.getUtPseudo(), ut);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors du chargement des utilisateurs");
        }
        return list;

    }

}
