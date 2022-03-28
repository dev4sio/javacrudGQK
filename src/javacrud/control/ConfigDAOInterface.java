/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrud.control;
import javacrud.tech.XMLLocal;
import javacrud.model.Configuration;
/**
 *
 * @author g.gerbaud
 */
public interface ConfigDAOInterface {
    void initXMLFile();
    
    public static Configuration getConfiguration(){
        Configuration c = new Configuration();
        return c;
    }
    public static void saveXMLFile(Configuration configuration){
        
    }
}
