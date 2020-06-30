
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import util.User;
import util.paylasimlar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author okano
 */
public class profileDAO {

    public static List<paylasimlar> paylasimcek(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        List<paylasimlar> mylist;
        mylist = new ArrayList<>();
       

        try {
            DBConnection db = new DBConnection();
            con = db.connect();
            ps = con.prepareStatement("SELECT * FROM PAYLASIM_TABLE WHERE USER_ID=?");
            ps.setInt(1, user.user_id);

            ResultSet rs = ps.executeQuery();
            paylasimlar temp;
            if (rs.next()) {
                
                temp = new paylasimlar(rs.getInt("USER_ID"), rs.getString("PAYLASIM"),rs.getDate("DATE"), rs.getInt("PAYLASIM_ID"));

                mylist.add(temp);
            }
           
            return mylist;

        } catch (Exception ex) {
            System.out.println("Hata Bulundu");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Hata Bulundu");
            }
        }
        return mylist;
    }
}
