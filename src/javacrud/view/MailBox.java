/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javacrud.view;
import javacrud.view.Mail;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.control.ConfigDAO;
import javacrud.model.Configuration;
import javacrud.model.MailModel;
import javacrud.model.Utilisateur;
import javacrud.tech.UtilDB;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Guilhem
 */
public class MailBox extends javax.swing.JFrame {
    
    
  private static final String HOST = "pop.gmail.com";
  private static final String USERNAME = "myemail@gmail.com";
  private static final String PASSWORD = "******";
  private Utilisateur currentUser;

    /**
     * Creates new form MailBox
     */
  
    //Il faut metttre un try/catch à chaque instanciation d'objet
    public MailBox(Utilisateur ut) throws Exception{
        
        this.currentUser = ut; 
        
        initComponents();
        
        // mail server connection parameters
        Configuration configMail = ConfigDAO.getConfiguration();
        
        
        String host = configMail.getMailHost();
        String user = configMail.getMailUser();
        String password = configMail.getMailPass();

        // connect to my pop3 inbox
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore("pop3");
        store.connect(host, user, password);
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY);

        // get the list of inbox messages
        Message[] messages = inbox.getMessages();
        
        if (messages.length == 0) System.out.println("No messages found.");
        
        
         
        
        try {
            Connection con = UtilDB.getConnect();
            for (int i = 0; i < messages.length; i++) {
                String sql = "INSERT IGNORE INTO mail VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, messages[i].getMessageNumber());
                ps.setString(2, currentUser.getUtPseudo());
                //On veut que l'adresse et pas le reste
                String[] mailAddrTab = messages[i].getFrom()[0].toString().split("<");
                mailAddrTab = mailAddrTab[1].split(">");
                String adresseMail = mailAddrTab[0];
                ps.setString(3, adresseMail);
                ps.setString(4, user);
                ps.setString(5, messages[i].getSubject());
                ps.setString(6, messages[i].getContent().toString());
                DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ps.setString(7, simple.format(new Date(messages[i].getSentDate().getTime())));
                ps.setString(8, "2021-10-12 09:17:45");
                ps.executeUpdate();
            }  
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : FAIL INSERT DANS MAIL");
        }
    

        for (int i = 0; i < messages.length; i++) {
          // stop after listing ten messages
          if (i > 10) {
            System.exit(0);
            inbox.close(true);
            store.close();
          }

          System.out.println("Message " + (i + 1));
          String[] mailAddrTab = messages[i].getFrom()[0].toString().split("<");
          mailAddrTab = mailAddrTab[1].split(">");
          String adresseMail = mailAddrTab[0];
          System.out.println("From : " + adresseMail);
          System.out.println("To : " + user);
          System.out.println("Subject : " + messages[i].getSubject());
          DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          System.out.println("Sent Date : " + simple.format(new Date(messages[i].getSentDate().getTime())));
          System.out.println("Message Number : " + messages[i].getMessageNumber());
          System.out.println(messages[i].getContent().toString());
          
          //MailModel mailModel = new MailModel(messages[i].getFrom()[0], Arrays.toString(messages[i].getReplyTo()), messages[i].getSubject(), );
          
        }

        inbox.close(true);
        store.close();
    }

    private MailBox() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonEnvoyerMail = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Envoyeur", "Objet", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Messages Reçus", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Destinataire", "Objet", "Date"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Messages Envoyés", jPanel2);

        jButtonEnvoyerMail.setText("Envoyer un mail");
        jButtonEnvoyerMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEnvoyerMailMouseClicked(evt);
            }
        });

        jButtonQuitter.setText("Quitter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButtonQuitter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(jButtonEnvoyerMail)
                .addGap(71, 71, 71))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnvoyerMail)
                    .addComponent(jButtonQuitter))
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 54, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnvoyerMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEnvoyerMailMouseClicked
        new Mail().setVisible(true);
    }//GEN-LAST:event_jButtonEnvoyerMailMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MailBox().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MailBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnvoyerMail;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
