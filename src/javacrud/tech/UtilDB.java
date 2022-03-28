/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.control.ConfigDAO;
import javacrud.model.Configuration;
/**
 *
 * @author g.gerbaud
 */
public class UtilDB {
        static Connection con;

    public static Connection getConnect() throws Exception {
        Configuration configBDD = ConfigDAO.getConfiguration();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + configBDD.getMysqlHost() + ":"+ configBDD.getMysqlPort() +"/"+ configBDD.getMysqlDb();
        String user = configBDD.getMysqlUser();
        String pass = configBDD.getMysqlPass();

        if(con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);      
        }
            return con;

            



    }

}
