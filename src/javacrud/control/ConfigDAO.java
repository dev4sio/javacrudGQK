/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import javacrud.model.Configuration;
import javacrud.tech.XMLLocal;
import javacrud.model.Configuration;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Element;
import org.jdom2.Document;

/**
 *
 * @author g.gerbaud
 */
public class ConfigDAO implements ConfigDAOInterface {

    public static Configuration getConfiguration() {
        Configuration c = new Configuration();
        try {
            Document docXML = XMLLocal.getDocument();
            Element docRoot = docXML.getRootElement();
            List<Element> lesParamsMail = docRoot.getChildren("mail");
            for (Element paramMail : lesParamsMail) {
                c.setMailProtocol(paramMail.getChildText("protocol"));
                c.setMailHost(paramMail.getChildText("host"));
                c.setMailPort(paramMail.getChildText("port"));
                c.setMailUser(paramMail.getChildText("user"));
                c.setMailPass(paramMail.getChildText("password"));
            }
            List<Element> lesParamsMysql = docRoot.getChildren("mysql");
            for (Element paramMysql : lesParamsMysql) {
                c.setMysqlHost(paramMysql.getChildText("host"));
                c.setMysqlPort(paramMysql.getChildText("port"));
                c.setMysqlDb(paramMysql.getChildText("database"));
                c.setMysqlUser(paramMysql.getChildText("user"));
                c.setMysqlPass(paramMysql.getChildText("password"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Config : Erreur d'initialisation");
        }
        return c;
    }

    /**
     * Faut écrire cette méthode
     */
    @Override
    public void initXMLFile() {
        try{
            Element config = new Element("configuration");
            Document docXML = new Document(config);
            Element mail = new Element("mail");
            mail.addContent(new Element("protocol").setText("ohoh"));
            mail.addContent(new Element("host").setText("ohoh"));
            mail.addContent(new Element("port").setText("ohoh"));
            mail.addContent(new Element("user").setText("ohoh"));
            mail.addContent(new Element("password").setText("ohoh"));
            docXML.getRootElement().addContent(mail);
            Element mysql = new Element("mysql");
            mysql.addContent(new Element("host").setText("ohoh"));
            mysql.addContent(new Element("port").setText("ohoh"));
            mysql.addContent(new Element("database").setText("ohoh"));
            mysql.addContent(new Element("user").setText("ohoh"));
            mysql.addContent(new Element("password").setText("ohoh"));
            docXML.getRootElement().addContent(mysql);
            XMLLocal.saveDocument(docXML);
            JOptionPane.showMessageDialog(null, "Config : Initialisation du fichier xml réussi !");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Config : Erreur d'initialisation");
        }
    }

    public static void saveXMLFile(Configuration c) {
        try {
            Element config = new Element("configuration");
            Document docXML = new Document(config);
            Element mail = new Element("mail");
            mail.addContent(new Element("protocol").setText(c.getMailProtocol()));
            mail.addContent(new Element("host").setText(c.getMailHost()));
            mail.addContent(new Element("port").setText(c.getMailPort()));
            mail.addContent(new Element("user").setText(c.getMailUser()));
            mail.addContent(new Element("password").setText(c.getMailPass()));
            docXML.getRootElement().addContent(mail);
            Element mysql = new Element("mysql");
            mysql.addContent(new Element("host").setText(c.getMysqlHost()));
            mysql.addContent(new Element("port").setText(c.getMysqlPort()));
            mysql.addContent(new Element("database").setText(c.getMysqlDb()));
            mysql.addContent(new Element("user").setText(c.getMysqlUser()));
            mysql.addContent(new Element("password").setText(c.getMysqlPass()));
            docXML.getRootElement().addContent(mysql);
            XMLLocal.saveDocument(docXML);
            JOptionPane.showMessageDialog(null, "Config : sauvegarde config.xml réussi");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Config : Erreur sauvegarde config.xml");
        }
    }

}
