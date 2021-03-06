/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.view;

/**
 *
 * @author patrick DUPRE
 */
import java.util.Properties;
import java.util.Date;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// https://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
public class Mail extends javax.swing.JFrame {

    
        public static final String USERNAME = "romain.bessede@st2msi.net";
        public static final String PASSWORD = "JpQ41_11;,kH";
    
	/**
	 * Creates new form mail
	 *
     * @param destinatiare
	 * @param destinataire
	 */
	public Mail(String destinataire) {
		initComponents();
		//Entete.setBackground(new java.awt.Color(0,128,255,30));
		jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255,100));
		uiMail.setText(destinataire);
                
            //Lire Mail Pop
            Properties props = new Properties();
            props.put("mail.store.protocol", "pop3");
            props.put("mail.pop3.host", "mail.st2msi.net");
            props.put("mail.pop3.port", "995");
            //props.put("mail.smtp.auth", "true");
            props.put("mail.pop3.socketFactory.port", "995");
            props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            props.put("mail.pop3.user", USERNAME);
            //props.put("mail.pop3.socketFactory.fallback", "false");
            //props.put("mail.pop3.ssl.protocols", "TLSv1.2");
            
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPassordAuthentification(){
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            
            
            

	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        
        public Mail() {
            initComponents();
            //Entete.setBackground(new java.awt.Color(0,128,255,30));
            jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255,100));
	}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Entete = new javax.swing.JLabel();
        Abandonner = new javax.swing.JButton();
        Envoyer = new javax.swing.JButton();
        jLabelMail = new javax.swing.JLabel();
        uiMail = new javax.swing.JTextField();
        jLabelObjet = new javax.swing.JLabel();
        uiObjet = new javax.swing.JTextField();
        jLabelMsg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        uiMsg = new javax.swing.JTextArea();
        uiBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        Entete.setBackground(new java.awt.Color(0,128,255,30));
        Entete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Entete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/java_64.png"))); // NOI18N
        Entete.setText("E n v o y e r    u n    m a i l");
        Entete.setIconTextGap(22);
        Entete.setOpaque(true);
        getContentPane().add(Entete);
        Entete.setBounds(0, 0, 699, 71);

        Abandonner.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Abandonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/escape_20.png"))); // NOI18N
        Abandonner.setText("Abandonner");
        Abandonner.setToolTipText("Sortir de la fen??tre d'envoi");
        Abandonner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbandonnerMouseClicked(evt);
            }
        });
        getContentPane().add(Abandonner);
        Abandonner.setBounds(542, 390, 123, 26);

        Envoyer.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Envoyer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/valid_20.png"))); // NOI18N
        Envoyer.setText("Envoyer");
        Envoyer.setToolTipText("Envoyer le mail ?? son destinataire");
        Envoyer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnvoyerMouseClicked(evt);
            }
        });
        getContentPane().add(Envoyer);
        Envoyer.setBounds(12, 390, 101, 26);

        jLabelMail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelMail.setText("Destinataire :");
        getContentPane().add(jLabelMail);
        jLabelMail.setBounds(12, 86, 94, 24);
        getContentPane().add(uiMail);
        uiMail.setBounds(118, 83, 569, 32);

        jLabelObjet.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelObjet.setText("Objet :");
        getContentPane().add(jLabelObjet);
        jLabelObjet.setBounds(12, 124, 94, 24);
        getContentPane().add(uiObjet);
        uiObjet.setBounds(118, 121, 569, 32);

        jLabelMsg.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabelMsg.setText("Mail ");
        getContentPane().add(jLabelMsg);
        jLabelMsg.setBounds(12, 171, 94, 24);

        jScrollPane1.setBackground(new java.awt.Color(255,255,255,70));

        uiMsg.setBackground(new java.awt.Color(255, 255, 255,100));
        uiMsg.setColumns(20);
        uiMsg.setRows(5);
        jScrollPane1.setViewportView(uiMsg);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(118, 171, 569, 176);

        uiBackground.setBackground(new java.awt.Color(255,255,255,70));
        uiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/back_ec.jpg"))); // NOI18N
        uiBackground.setMaximumSize(new java.awt.Dimension(700, 430));
        uiBackground.setMinimumSize(new java.awt.Dimension(700, 430));
        uiBackground.setPreferredSize(new java.awt.Dimension(700, 430));
        getContentPane().add(uiBackground);
        uiBackground.setBounds(0, 0, 700, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void AbandonnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbandonnerMouseClicked
		// TODO add your handling code here:
		this.dispose();
        }//GEN-LAST:event_AbandonnerMouseClicked

	@SuppressWarnings("CallToPrintStackTrace")
        private void EnvoyerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnvoyerMouseClicked
		// TODO add your handling code here:
		
// information de connexion au serveur SMTP
		
/*Important PORT & Server information for your email client setup:

Server name: secure (SSL) outgoing & incoming: mocha3021.mochahost.com or no-SSL: mail.yourdomain.com

Outgoing SMTP port: 25 or if your ISP is blocking your email, use port 2525. Secure (SSL) SMTP port is 465

SMTP authentication: Make sure to check that in your email client. Authentication is the same as your incoming email/password.

Incoming email ports: POP3 110, Secure (SSL) POP3 995, IMAP 143, Secure (SSL) IMAP 993

Webmail Secure Link: https://mocha3021.mochahost.com:2096/

Online Video Tutorials: check these for the most popular email clients.*/
		/* Email configuration pour ???mailflex@st2msi.net???.
			(maiflex@st2msi.net mp=uOBtCU5pdL!Y)

			Mail Client Settings
			--------------------
			Secure SSL/TLS Settings (recommand??)
			Nom d???utilisateur : mailflex@st2msi.net
			Mot de passe : uOBtCU5pdL!Y
			Serveur entrant : mail.st2msi.net
			  * IMAP Port: 993
			  * POP3 Port: 995
			Serveur sortant : mail.st2msi.net
			  * SMTP Port: 465
			IMAP, POP3 et SMTP => require authentication.*/
		

		final String user = "mailflex@st2msi.net";  
		final String password = "uOBtCU5pdL!Y"; 

		// Param??trer l'objet "session"  
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host",  "mail.st2msi.net"); // h??bergeur smtp
		props.put("mail.stmp.port", "465"); // port smtp
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		Session session = Session.getDefaultInstance(props,
		    new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		//param??trer et envoyer le message 
		// lien entre l'??cran et le mail : uiMail, uiObjet, uiMsg
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(uiMail.getText().strip()));
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			message.setHeader("X-Mailer", "st2msi.net/JavaMail version 1.6.2");
			message.setSentDate(new Date());
			message.setSubject(uiObjet.getText().strip(), "UTF-8");
			message.setText(uiMsg.getText(), "UTF-8");

			//send the message 
			session.setDebug(true); // passer ?? false en production
			Transport.send(message);

			System.out.println("message envoy?? avec succ??s ...");

		} catch (MessagingException ev) {
			ev.printStackTrace();
		}

        }//GEN-LAST:event_EnvoyerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JLabel Entete;
    private javax.swing.JButton Envoyer;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JLabel jLabelObjet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel uiBackground;
    private javax.swing.JTextField uiMail;
    private javax.swing.JTextArea uiMsg;
    private javax.swing.JTextField uiObjet;
    // End of variables declaration//GEN-END:variables
}
