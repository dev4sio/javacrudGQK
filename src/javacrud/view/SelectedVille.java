/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javacrud.view;

import javacrud.view.UtilCrud;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javacrud.control.VilleDAOImp;
import javacrud.model.Commune;
import java.util.HashMap;
import javacrud.model.Utilisateur;
import javax.swing.JTable;

/**
 *
 * @author g.gerbaud
 */
public class SelectedVille extends javax.swing.JDialog {

    private boolean selected;
    private Commune selectedVille;
    private HashMap<Integer, Commune> listeVille;

    /**
     * Creates new form ListeVille
     */
    public SelectedVille(java.awt.Frame parent, boolean modal, String codePostal, String numPost) {
        super(parent, modal);
        initComponents();
        setListeVillePourCPstatic(codePostal);
        chargerTableauVille();

    }

    public boolean isSelected() {
        return true;
    }

    public void setListeVillePourCPstatic(String codePostal) {
        VilleDAOImp vdi = new VilleDAOImp();
        this.listeVille = vdi.villesPourCp(codePostal);
    }


    private void chargerTableauVille() {
        DefaultTableModel uiTable = (DefaultTableModel) jTable1.getModel();
        /**
         * Cette boucle enlêve les lignes
         */
        int j = uiTable.getRowCount();
        for (int i = j - 1; i >= 0; i--) {
            uiTable.removeRow(i);
        }

        for (Integer numero : listeVille.keySet()) {
            Commune uneVille = listeVille.get(numero);
            Object[] row = new Object[2];
            row[0] = uneVille.getNum_Postal();
            row[1] = uneVille.getNom_Commune();

            uiTable.addRow(row);
        }
    }

    private void chargerVilles() {
    }
    
    private void setSelectedVilleViaNum(int numVille){
        this.selectedVille = this.listeVille.get(numVille);
        
    }
    
    public Commune getSelectedVille(){
        return this.selectedVille;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonValider = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Num Post", "Villes"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButtonValider)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonValider)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // TODO add your handling code here:
        
        //Colonne vaut 1 car on veut le nom de la ville, pas le num, quelque soit la colonne selectionné, seullement celle la valeur de la ville nous intéresse
        int colonne = 0;
        int ligne = jTable1.getSelectedRow();
        int numVille = Integer.parseInt((String) jTable1.getValueAt(ligne, colonne));
        setSelectedVilleViaNum(numVille);
        this.dispose();
    }//GEN-LAST:event_jButtonValiderActionPerformed

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
            java.util.logging.Logger.getLogger(SelectedVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectedVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectedVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectedVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectedVille dialog = new SelectedVille(new javax.swing.JFrame(), true, "caca", "popo");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
