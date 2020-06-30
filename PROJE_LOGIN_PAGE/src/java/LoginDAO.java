

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;
import util.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class LoginDAO {
    
    
    public static User validate(String user,String password){ 
        Connection con = null;
        PreparedStatement ps = null;
        User temp=new User();
        try{
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("SELECT * FROM USER_TABLE WHERE EMAIL=? AND PASSWORD=? ");
            ps.setString(1, user);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
           
             

            if(rs.next()){
                
                temp.setUser_id(rs.getInt("USER_ID")); //ATAMA İŞLEMLERİNİ YAPIYORUM BURADA.
                temp.setName(rs.getString("NAME"));
                temp.setSurname(rs.getString("SURNAME"));
                temp.setEmail(rs.getString("EMAIL"));
                temp.setPassword(rs.getString("PASSWORD"));
                temp.setGender(rs.getString("GENDER"));
              return temp;  
            }
            return temp;
            
        }
        catch(Exception ex){
            System.out.println("Hata Bulundu");
        }
        finally{
            try{
            con.close();
            }
            catch(Exception ex){
                System.out.println("Hata Bulundu");
            }
        }
        return temp;
    }
    public static boolean kayitYap(String name,String surname,String email,String password,String gender){
        int i = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("INSERT INTO USER_TABLE(NAME,SURNAME,EMAIL,PASSWORD,GENDER) VALUES(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2, surname);
            ps.setString(3,email);
            ps.setString(4, password);
            ps.setString(5, gender);
            i = ps.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("kayıt yapılamadı..");
        }
         finally{
            try{
            con.close();
            }
            catch(Exception ex){
                System.out.println("Hata Bulundu");
            }
        }
        if(i>0){
            return true;
        }
        else
            return false;
    }
}
