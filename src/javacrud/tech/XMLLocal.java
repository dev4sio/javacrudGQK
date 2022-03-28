/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.nio.file.Paths;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;
import org.jdom2.input.SAXBuilder;
import javacrud.control.ConfigDAO;
import java.io.FileWriter;
import java.io.Writer;
import java.io.File;

/**
 *
 * @author g.gerbaud
 */
public class XMLLocal {
    /**
     * 
     * @return 
     */
    public static Document getDocument() throws Exception{
        Document docXML;
        String path;
        String homePath = System.getProperty("user.home");
        File fichier = new File(Paths.get(homePath,".javacrud").toString());
        if(!fichier.exists()){
            fichier.mkdir();
        }
        path = Paths.get(homePath, ".javacrud", "config.xml").toString();
        fichier = new File(path);
        if(!fichier.exists()){
            new ConfigDAO().initXMLFile();
        }
        SAXBuilder builder = new SAXBuilder();
        docXML = builder.build(new File(path));
        return docXML;
    }
    
    public static void saveDocument(Document docXML) throws Exception{
        String path = Paths.get(System.getProperty("user.home"), ".javacrud", "config.xml").toString();
        File fichier = new File(path);
        XMLOutputter xml = new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        xml.output(docXML, new FileWriter(path));
    }
}
