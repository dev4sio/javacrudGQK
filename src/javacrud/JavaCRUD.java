/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author g.gerbaud
 */
public class JavaCRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con; 
        String url = "jdbc:mysql://localhost:3306/gestion_utilisateur";
        String user = "root";
        String pass = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            String rqSql = "SELECT Code_Postal, Num_Postal, Nom_Commune FROM codes_postaux";
            PreparedStatement ps = con.prepareStatement(rqSql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                System.out.print(result.getString("Code_Postal") + " " + result.getString("Num_Postal") + " " + result.getString("Nom_Commune") + "\n");
            }
        }catch(Exception e){
            
        }
        
        
        
        
        
        
        
    }
    
}
