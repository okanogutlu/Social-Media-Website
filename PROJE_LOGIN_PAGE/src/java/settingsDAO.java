
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
 * @author okano
 */
public class settingsDAO {

    public static void isimguncelleme(User user1) {
        int id = user1.user_id;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("UPDATE USER_TABLE SET NAME=? WHERE USER_ID=?");
            ps.setString(1, user1.name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
    }

    public static void soyisimguncelleme(User user1) {
        int id = user1.user_id;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("UPDATE USER_TABLE SET SURNAME=? WHERE USER_ID=?");
            ps.setString(1, user1.surname);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
    }

    public static void emailguncelleme(User user1) {
         int id = user1.user_id;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("UPDATE USER_TABLE SET EMAIL=? WHERE USER_ID=?");
            ps.setString(1, user1.email);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
    }

    public static void sifreguncelleme(User user1) {
        int id = user1.user_id;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("UPDATE USER_TABLE SET PASSWORD=? WHERE USER_ID=?");
            ps.setString(1, user1.password);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
    }

    public static void silme(User user1) {
       int id = user1.user_id;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("DELETE FROM USER_TABLE WHERE USER_ID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
    }

}
