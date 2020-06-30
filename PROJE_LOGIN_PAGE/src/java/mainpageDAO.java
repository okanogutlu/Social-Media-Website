
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import util.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import util.paylasimlar;
import util.yorumlar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author okano
 */
public class mainpageDAO {

    public static List<User> search(String s) {
        int count = 1;//kelime sayısını bulur.
        List<User> mylist = new ArrayList<>();
        if (count == 2) { //Ad-Soyad girilmişse
            String[] splited = s.split("\\s+");
            Connection con = null;
            PreparedStatement ps = null;
            try {
                DBConnection db = new DBConnection();
                con = db.connect();
                ps = con.prepareStatement("SELECT * FROM USER_TABLE WHERE NAME=? AND SURNAME=?");
                ps.setString(1, splited[0]);
                ps.setString(2, splited[1]);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User tmp;
                    tmp = new User(rs.getInt("USER_ID"), rs.getString("NAME"), rs.getString("SURNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("GENDER"));
                    mylist.add(tmp);
                }

                return mylist;
            } catch (Exception ex) {
                System.out.println("kayıt yapılamadı..");
            } finally {
                try {
                    con.close();
                } catch (Exception ex) {
                    System.out.println("Hata Bulundu");
                }
            }
        } else { //Sadece ad girilmişse
            Connection con = null;
            PreparedStatement ps = null;
            try {
                DBConnection db = new DBConnection();
                con = db.connect();
                ps = con.prepareStatement("SELECT * FROM USER_TABLE WHERE NAME=?");
                ps.setString(1, s);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User tmp;
                    tmp = new User(rs.getInt("USER_ID"), rs.getString("NAME"), rs.getString("SURNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("GENDER"));
                    mylist.add(tmp);
                }

                return mylist;
            } catch (Exception ex) {
                System.out.println("kayıt yapılamadı..");
            } finally {
                try {
                    con.close();
                } catch (Exception ex) {
                    System.out.println("Hata Bulundu");
                }
            }
        }
        return mylist;
    }

    public static int countWords(String s) {

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static void sharedb(int id, String sharing) throws SQLException {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Statement st = c.createStatement();
        //ResultSet id=st.executeQuery("select * from USER_TABLE where email='"+email+"'");
        st.executeUpdate("insert into PAYLASIM_TABLE(USER_ID,PAYLASIM,DATE) values(" + id + ",'" + sharing + "',CURRENT_DATE)");
    }

    public static void ekle(User user) throws SQLException {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Statement st = c.createStatement();
        st.execute("insert into FRIEND_TABLE values(" + Login.user1.getUser_id() + ", " + user.user_id + ")");
    }

    public static List<paylasimlar> arkadascek(User user1) throws SQLException {
        List<paylasimlar> mylist = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("SELECT FRIEND_ID FROM FRIEND_TABLE WHERE USER_ID=?");
            ps.setInt(1, user1.getUser_id());
            rs = ps.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt("FRIEND_ID"));
            }

            mylist = gondericek(ids);
            return gondericek(ids);
        } catch (Exception ex) {
            System.out.println("kayıt yapılamadı..");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }

        return gondericek(ids);
    }

    public static String[] isimcek(int id) {
        int i = 0;
        String isim;
        String soyisim;
        String[] isimsoyisim = new String[2];
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try { //try bloğunun dışına çıkarınca çalışıyor.içinde çalışmıyor.Sorun burada..
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("SELECT NAME, SURNAME FROM USER_TABLE WHERE USER_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                isimsoyisim[i++] = rs.getString("NAME");
                isimsoyisim[i++] = rs.getString("SURNAME");
            }

            return isimsoyisim;

        } catch (Exception ex) {
            System.out.println("kayıt yapılamadı..");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }

        return isimsoyisim;
    }

    public static List<paylasimlar> gondericek(ArrayList<Integer> ids) {
        String[] isimsoyisim;
        Connection con = null;
        PreparedStatement ps = null;
        List<paylasimlar> mylist;
        mylist = new ArrayList<>();
        ResultSet rs = null;
        paylasimlar temp;

        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            for (int i = 0; ids.size() > i; i++) {
                ps = con.prepareStatement("SELECT * FROM PAYLASIM_TABLE WHERE USER_ID=?");
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();
                isimsoyisim = isimcek(ids.get(i));
                while (rs.next()) {

                    temp = new paylasimlar(isimsoyisim[0], isimsoyisim[1], rs.getInt("USER_ID"), rs.getString("PAYLASIM"), rs.getDate("DATE"), rs.getInt("PAYLASIM_ID"));
                    mylist.add(temp);
                }
            }
        } catch (Exception ex) {
            System.out.println("kayıt yapılamadı..");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
        return mylist;
    }

    static List<yorumlar> yorumdao(paylasimlar paylasim) {
        yorumlar temp;
        List<yorumlar> mylist = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("SELECT * FROM COMMENT WHERE PAYLASIM_ID=?");
            ps.setInt(1, paylasim.paylasim_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                temp = new yorumlar(rs.getInt("PAYLASIM_ID"), rs.getString("NAME"), rs.getString("SURNAME"), rs.getString("COMMENT"), rs.getDate("DATE"));
                mylist.add(temp);
            }

            return mylist;
        } catch (Exception ex) {
            System.out.println("kayıt yapılamadı..");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }

        return mylist;
    }

    public static void youmdao(paylasimlar paylasim) throws SQLException {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Statement st = c.createStatement();
        st.execute("insert into COMMENT values("+paylasim.paylasim_id+", '"+Login.user1.name+"' , '"+Login.user1.surname+"' , '"+mainpage.yorum+"', CURRENT_DATE)");
    }
}


