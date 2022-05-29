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
import java.util.TreeMap;
import javacrud.model.MailModel;
import javacrud.model.Utilisateur;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Guilhem
 */
public class MailDAO {
    
    public MailDAO(){
        
    }
     public void insert(Message unMail, Utilisateur currentUser, String mailConf) throws Exception{
        
        try {
            Connection con = UtilDB.getConnect();
                String sql = "INSERT IGNORE INTO mail VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, unMail.getMessageNumber());
                ps.setString(2, currentUser.getUtPseudo());
                //On veut que l'adresse et pas le reste
                String[] mailAddrTab = unMail.getFrom()[0].toString().split("<");
                mailAddrTab = mailAddrTab[1].split(">");
                String adresseMail = mailAddrTab[0];
                ps.setString(3, adresseMail);
                ps.setString(4, mailConf);
                ps.setString(5, unMail.getSubject());
                ps.setString(6, unMail.getContent().toString());
                DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ps.setString(7, simple.format(new Date(unMail.getSentDate().getTime())));
                ps.setString(8, "2021-10-12 09:17:45");
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : FAIL INSERT DANS MAIL");
        }
    }
     
    public List<MailModel> list(Utilisateur user) {
    List<MailModel> list = new ArrayList<MailModel>();
    try {
        Connection con = UtilDB.getConnect();
        String sql = "SELECT * FROM mail WHERE utilisateur_pseudo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUtPseudo());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            MailModel mail = new MailModel();
            mail.setExpediteur(rs.getString("expediteur"));
            mail.setDestinataire(rs.getString("destinataire"));
            mail.setObjet(rs.getString("objet"));
            mail.setContenuMail(rs.getString("contenumail"));
            mail.setDateEnvoie(rs.getDate("dateenvoie"));
            mail.setDateReception(rs.getDate("dateenvoie"));

            list.add(mail);
        }
        JOptionPane.showMessageDialog(null, "DB Mail : Réussite de récupération des mails !");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "DB Mail : échec de la récupération des mails");
    }
    return list;

    }
}
