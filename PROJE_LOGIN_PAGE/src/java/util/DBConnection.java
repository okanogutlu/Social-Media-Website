/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class DBConnection {
    private final String dburl= "jdbc:derby://localhost:1527/sample";
    private final String class_ = "org.apache.derby.jdbc.ClientDriver";
    private final String user = "app";
    private final String pass ="app";
    public Connection connect(){
        Connection c = null;
        try{
          Class.forName(class_);
          c = DriverManager.getConnection(dburl,user,pass);
        }catch(Exception e){
            System.out.println("bağlantıda sorun var");
            e.printStackTrace();
        }
        return c;
    }
}
