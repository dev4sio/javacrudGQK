/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javacrud.view;

import java.sql.Connection;
import java.sql.Statement;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javacrud.model.Utilisateur;
import javacrud.control.UtilisateurDAOImp;
import javacrud.model.Commune;
import javacrud.view.Parametre;

/**
 *
 * @author g.gerbaud
 */
public class UtilCrud extends javax.swing.JFrame {

    /**
     * Creates new form UtilCrud
     */
    Connection con;
    Statement st;
    TreeMap<String, Utilisateur> lesUtilisateurs = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    UtilisateurDAOImp dao = new UtilisateurDAOImp();
    String uiNumpost;
    private Object[] selectedVille;
    private Commune laVille;

    public UtilCrud() {
        initComponents();
        message.setText("Veuillez choisir un utilisateur dans le tableau de droite ou saisir les données à creer");
        chargerLesUtilisateurs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSaisie = new javax.swing.JPanel();
        jLabelNom = new javax.swing.JLabel();
        uiNom = new javax.swing.JTextField();
        jLabelPrenom = new javax.swing.JLabel();
        uiPrenom = new javax.swing.JTextField();
        jLabelPseudo = new javax.swing.JLabel();
        uiPseudo = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        uiMail = new javax.swing.JTextField();
        jLabelMDP = new javax.swing.JLabel();
        uiMDP = new javax.swing.JTextField();
        jLabelAdresse = new javax.swing.JLabel();
        uiAdresse1 = new javax.swing.JTextField();
        uiAdresse2 = new javax.swing.JTextField();
        jLabelCodePost = new javax.swing.JLabel();
        uiCodePost = new javax.swing.JTextField();
        ChercherVille = new javax.swing.JButton();
        Creer = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        Nouveau = new javax.swing.JButton();
        uiVille = new javax.swing.JTextField();
        uiPhrase = new javax.swing.JLabel();
        tbScrollPane = new javax.swing.JScrollPane();
        tbUtilisateur = new javax.swing.JTable();
        jPanelBt = new javax.swing.JPanel();
        message = new javax.swing.JLabel();
        Mail = new javax.swing.JButton();
        AuSujet = new javax.swing.JButton();
        Aide = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        Parametre = new javax.swing.JButton();
        Entete = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1022, 669));
        setMinimumSize(new java.awt.Dimension(1022, 669));
        setPreferredSize(new java.awt.Dimension(1022, 669));
        setResizable(false);
        setSize(new java.awt.Dimension(1022, 669));
        getContentPane().setLayout(null);

        jPanelSaisie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSaisie.setOpaque(false);

        jLabelNom.setText("Nom");

        jLabelPrenom.setText("Prénom");

        jLabelPseudo.setText("Utilisateur");

        jLabelMail.setText("Mail");

        jLabelMDP.setText("Mot de passe");

        jLabelAdresse.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAdresse.setText("Adresse");

        jLabelCodePost.setText("Code Postal");

        uiCodePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiCodePostActionPerformed(evt);
            }
        });

        ChercherVille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/eye_20.png"))); // NOI18N
        ChercherVille.setText("Ville");
        ChercherVille.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChercherVilleMouseClicked(evt);
            }
        });
        ChercherVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChercherVilleActionPerformed(evt);
            }
        });

        Creer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/plus_20.png"))); // NOI18N
        Creer.setText("Créer");
        Creer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreerMouseClicked(evt);
            }
        });
        Creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreerActionPerformed(evt);
            }
        });

        Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/pencil_20.png"))); // NOI18N
        Modifier.setText("Modifier");
        Modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifierMouseClicked(evt);
            }
        });
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        Supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/minus_20.png"))); // NOI18N
        Supprimer.setText("Supprimer");
        Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprimerMouseClicked(evt);
            }
        });
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        Nouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/eye-slash_20.png"))); // NOI18N
        Nouveau.setText("Nouveau");
        Nouveau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NouveauMouseClicked(evt);
            }
        });
        Nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NouveauActionPerformed(evt);
            }
        });

        uiVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiVilleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSaisieLayout = new javax.swing.GroupLayout(jPanelSaisie);
        jPanelSaisie.setLayout(jPanelSaisieLayout);
        jPanelSaisieLayout.setHorizontalGroup(
            jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uiPhrase, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPrenom)
                                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                        .addComponent(jLabelCodePost)
                                        .addGap(18, 18, 18)
                                        .addComponent(uiCodePost, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelPseudo)
                                                    .addComponent(jLabelMail))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(uiMail, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(uiPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                                        .addComponent(jLabelNom)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(uiNom, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSaisieLayout.createSequentialGroup()
                                                        .addComponent(jLabelMDP)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(uiMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(uiPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Creer)
                                            .addComponent(Modifier)
                                            .addComponent(Supprimer)
                                            .addComponent(Nouveau)))
                                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                        .addComponent(jLabelAdresse)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(uiAdresse2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(uiAdresse1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addComponent(ChercherVille)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uiVille, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelSaisieLayout.setVerticalGroup(
            jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNom)
                            .addComponent(uiNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrenom)
                            .addComponent(uiPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPseudo)
                            .addComponent(uiPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMail)
                            .addComponent(uiMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMDP)
                            .addComponent(uiMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Creer)
                        .addGap(18, 18, 18)
                        .addComponent(Modifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Supprimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nouveau)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uiPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresse)
                    .addComponent(uiAdresse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uiAdresse2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodePost)
                    .addComponent(uiCodePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChercherVille)
                    .addComponent(uiVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        getContentPane().add(jPanelSaisie);
        jPanelSaisie.setBounds(460, 120, 550, 440);

        tbScrollPane.setBackground(new java.awt.Color(204, 204, 204));
        tbScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbUtilisateur.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tbUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prénom", "Utilisateur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUtilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUtilisateurMouseClicked(evt);
            }
        });
        tbUtilisateur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbUtilisateurKeyReleased(evt);
            }
        });
        tbScrollPane.setViewportView(tbUtilisateur);
        if (tbUtilisateur.getColumnModel().getColumnCount() > 0) {
            tbUtilisateur.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(tbScrollPane);
        tbScrollPane.setBounds(40, 120, 400, 440);

        jPanelBt.setOpaque(false);

        message.setText("Message");

        Mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/envelope_20.png"))); // NOI18N
        Mail.setText("Mail");
        Mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MailMouseClicked(evt);
            }
        });
        Mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailActionPerformed(evt);
            }
        });

        AuSujet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/info-circle_20.png"))); // NOI18N
        AuSujet.setText("Au Sujet");

        Aide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/question-circle_20.png"))); // NOI18N
        Aide.setText("Aide");

        Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/escape_20.png"))); // NOI18N
        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        Parametre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/wrench._20.png"))); // NOI18N
        Parametre.setText("Paramètres");
        Parametre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParametreMouseClicked(evt);
            }
        });
        Parametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParametreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBtLayout = new javax.swing.GroupLayout(jPanelBt);
        jPanelBt.setLayout(jPanelBtLayout);
        jPanelBtLayout.setHorizontalGroup(
            jPanelBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Parametre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                .addComponent(Mail)
                .addGap(18, 18, 18)
                .addComponent(AuSujet)
                .addGap(18, 18, 18)
                .addComponent(Aide)
                .addGap(18, 18, 18)
                .addComponent(Quitter)
                .addGap(30, 30, 30))
            .addGroup(jPanelBtLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(message)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBtLayout.setVerticalGroup(
            jPanelBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBtLayout.createSequentialGroup()
                .addComponent(message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanelBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parametre)
                    .addComponent(Mail)
                    .addComponent(AuSujet)
                    .addComponent(Aide)
                    .addComponent(Quitter))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanelBt);
        jPanelBt.setBounds(40, 570, 970, 70);

        Entete.setBackground(new java.awt.Color(204, 204, 204));
        Entete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Entete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/java_64.png"))); // NOI18N
        Entete.setText("CRUD SIMPLIFIE : GESTION DES UTILISATEURS ET AUTRES RESSOURCES");
        Entete.setToolTipText("");
        Entete.setOpaque(true);
        getContentPane().add(Entete);
        Entete.setBounds(0, 0, 1030, 100);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/back_ec.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1024, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uiCodePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiCodePostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiCodePostActionPerformed

    private void MailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MailActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuitterActionPerformed

    private void ParametreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParametreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParametreActionPerformed

    private void ChercherVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChercherVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChercherVilleActionPerformed

    private void uiVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiVilleActionPerformed

    private void CreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreerActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifierActionPerformed

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerActionPerformed

    private void NouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NouveauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NouveauActionPerformed

    private void tbUtilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUtilisateurMouseClicked
        changeSelectUt();
    }//GEN-LAST:event_tbUtilisateurMouseClicked

    private void tbUtilisateurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbUtilisateurKeyReleased
        changeSelectUt();
    }//GEN-LAST:event_tbUtilisateurKeyReleased

    private void ChercherVilleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChercherVilleMouseClicked
        String codePostal = uiCodePost.getText().strip();
        if (codePostal.matches("[0-9]+") && codePostal.length() == 5) {
            SelectedVille sv = new SelectedVille(new javax.swing.JFrame(), true, codePostal, uiNumpost);
            sv.setVisible(true);
            String nomVille = sv.getSelectedVille().getNom_Commune();
            uiVille.setText(nomVille);
        }else{
            alert("Saisir un code postal (5 chiffres) avant de selectionner la ville.");
            return;
        }


    }//GEN-LAST:event_ChercherVilleMouseClicked

    private void ModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifierMouseClicked

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtNom(uiNom.getText());
        utilisateur.setUtPrenom(uiPrenom.getText());
        utilisateur.setUtPseudo(uiPseudo.getText());
        utilisateur.setUtMail(uiMail.getText());
        utilisateur.setUtMp(uiMDP.getText());
        utilisateur.updateUtMp(uiMDP.getText());
        utilisateur.setUtAdr1(uiAdresse1.getText());
        utilisateur.setUtAdr2(uiAdresse2.getText());
        utilisateur.setUtCdpost(uiCodePost.getText());
        String numPost = "0";
        utilisateur.setUtNumpost(numPost);
        utilisateur.setUtCommune(uiVille.getText());

        UtilisateurDAOImp obj = new UtilisateurDAOImp();
        obj.update(utilisateur);

        chargerLesUtilisateurs();
    }//GEN-LAST:event_ModifierMouseClicked

    private void CreerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreerMouseClicked
        /**
         * On créer un nouvel objet utilisateur afin de lui assigner les valeurs
         * contenues dans les champs
         */
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtNom(uiNom.getText());
        utilisateur.setUtPrenom(uiPrenom.getText());
        utilisateur.setUtPseudo(uiPseudo.getText());
        utilisateur.setUtMail(uiMail.getText());
        utilisateur.setUtMp(uiMDP.getText());
        utilisateur.updateUtMp(uiMDP.getText());
        utilisateur.setUtAdr1(uiAdresse1.getText());
        utilisateur.setUtAdr2(uiAdresse2.getText());
        utilisateur.setUtCdpost(uiCodePost.getText());
        String numPost = "0";
        utilisateur.setUtNumpost(numPost);
        utilisateur.setUtCommune(uiVille.getText());
        /**
         * On instancie la classe UtilisateurDAOImp pour accéder à la méthode
         * create() On lui donne l'objet utilisatteur
         */
        UtilisateurDAOImp obj = new UtilisateurDAOImp();
        obj.create(utilisateur);
        /**
         * OnRecharge les utilisateurs pour que ça corresponde à la base de
         * donnée
         */
        chargerLesUtilisateurs();
    }//GEN-LAST:event_CreerMouseClicked

    private void SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprimerMouseClicked

        UtilisateurDAOImp obj = new UtilisateurDAOImp();
        obj.delete(uiPseudo.getText());
        chargerLesUtilisateurs();
    }//GEN-LAST:event_SupprimerMouseClicked

    private void NouveauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NouveauMouseClicked
        ViderChamps();
    }//GEN-LAST:event_NouveauMouseClicked

    private void ParametreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParametreMouseClicked
        try {
            Parametre param = new Parametre(new javax.swing.JFrame(), true);
            param.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(UtilCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ParametreMouseClicked

    private void MailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailMouseClicked

            new Mail(uiMail.getText()).setVisible(true);
        
    }//GEN-LAST:event_MailMouseClicked

    private void chargerLesUtilisateurs() {
        lesUtilisateurs.clear();
        lesUtilisateurs = dao.list();
        chargerTableauUtilisateurs();

    }

    private void chargerTableauUtilisateurs() {

        DefaultTableModel uiTable = (DefaultTableModel) tbUtilisateur.getModel();
        /**
         * Cette boucle enlêve les lignes
         */
        int j = uiTable.getRowCount();
        for (int i = j - 1; i >= 0; i--) {
            uiTable.removeRow(i);
        }

        for (String pseudo : lesUtilisateurs.keySet()) {
            Utilisateur unUtilisateur = lesUtilisateurs.get(pseudo);
            Object[] row = new Object[3];
            row[0] = unUtilisateur.getUtNom();
            row[1] = unUtilisateur.getUtPrenom();
            row[2] = unUtilisateur.getUtPseudo();

            uiTable.addRow(row);
        }
    }

    // methode pour changer d'utilisateur
    private void changeSelectUt() {
        // pointer sur le colonnen selectionnée
        int i = tbUtilisateur.getSelectedRow();
        // récupérer les données de l'utilisateur
        // utiliser les données du tableau ou ...
        TableModel model = tbUtilisateur.getModel();
        Utilisateur unUtilisateur = lesUtilisateurs.get(model.getValueAt(i, 2).toString());
        uiNom.setText(unUtilisateur.getUtNom());
        uiPrenom.setText(unUtilisateur.getUtPrenom());
        uiPseudo.setText(unUtilisateur.getUtPseudo());
        uiMail.setText(unUtilisateur.getUtMail());
        uiMDP.setText(unUtilisateur.getUtMp());
        uiPhrase.setText(unUtilisateur.getUtPhrase());
        uiAdresse1.setText(unUtilisateur.getUtAdr1());
        uiAdresse2.setText(unUtilisateur.getUtAdr2());
        uiCodePost.setText(unUtilisateur.getUtCdpost());
        uiNumpost = unUtilisateur.getUtNumpost();
        uiVille.setText(unUtilisateur.getUtCommune());
    }

    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
        message.setForeground(new java.awt.Color(51, 102, 0));
        message.setText(msg);
    }

    public void alert(String msg, String titre) {
        JOptionPane.showMessageDialog(rootPane, msg, titre, JOptionPane.ERROR_MESSAGE);
        message.setForeground(new java.awt.Color(204, 0, 51));
        message.setText(msg);
    }

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
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UtilCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aide;
    private javax.swing.JButton AuSujet;
    private javax.swing.JButton ChercherVille;
    private javax.swing.JButton Creer;
    private javax.swing.JLabel Entete;
    private javax.swing.JButton Mail;
    private javax.swing.JButton Modifier;
    private javax.swing.JButton Nouveau;
    private javax.swing.JButton Parametre;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Supprimer;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelCodePost;
    private javax.swing.JLabel jLabelMDP;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelPseudo;
    private javax.swing.JPanel jPanelBt;
    private javax.swing.JPanel jPanelSaisie;
    private javax.swing.JLabel message;
    private javax.swing.JScrollPane tbScrollPane;
    private javax.swing.JTable tbUtilisateur;
    private javax.swing.JTextField uiAdresse1;
    private javax.swing.JTextField uiAdresse2;
    private javax.swing.JTextField uiCodePost;
    private javax.swing.JTextField uiMDP;
    private javax.swing.JTextField uiMail;
    private javax.swing.JTextField uiNom;
    private javax.swing.JLabel uiPhrase;
    private javax.swing.JTextField uiPrenom;
    private javax.swing.JTextField uiPseudo;
    private javax.swing.JTextField uiVille;
    // End of variables declaration//GEN-END:variables

    private void ViderChamps() {
        // pointer sur le colonnen selectionnée
        int i = tbUtilisateur.getSelectedRow();
        // récupérer les données de l'utilisateur
        // utiliser les données du tableau ou ...
        TableModel model = tbUtilisateur.getModel();
        Utilisateur unUtilisateur = lesUtilisateurs.get(model.getValueAt(i, 2).toString());
        uiNom.setText("");
        uiPrenom.setText("");
        uiPseudo.setText("");
        uiMail.setText("");
        uiMDP.setText("");
        uiPhrase.setText("");
        uiAdresse1.setText("");
        uiAdresse2.setText("");
        uiCodePost.setText("");
        uiNumpost = unUtilisateur.getUtNumpost();
        uiVille.setText("");
    }
}