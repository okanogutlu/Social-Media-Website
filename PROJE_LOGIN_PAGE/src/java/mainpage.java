
import util.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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
@ManagedBean
@SessionScoped
@RequestScoped
public class mainpage implements Serializable {

    public static String search;
    private String sharing;
    public static List<User> userlist;
    public static List<paylasimlar> paylasimlist;
    public static List<yorumlar> yorumlist;
    public static String yorum;

    
    public static String yorumat(paylasimlar paylasim) throws SQLException{
        mainpageDAO.youmdao(paylasim);
        yorum=null;
        return "admin";
    }
    
    
    public  String getYorum() {
        return yorum;
    }

    public  void setYorum(String yorum) {
        mainpage.yorum = yorum;
    }
    public static List<yorumlar> yorumcek(paylasimlar paylasim){
        yorumlist=mainpageDAO.yorumdao(paylasim);
        return yorumlist;
    }
    
    public  List<yorumlar> getYorumlist() {
        
        return yorumlist;
    }

    public  void setYorumlist(List<yorumlar> yorumlist) {
        mainpage.yorumlist = yorumlist;
    }
    
    

    public List<paylasimlar> getPaylasimlist() throws SQLException {
        paylasimlist = mainpageDAO.arkadascek(Login.user1);
        return paylasimlist;
    }

    public void setPaylasimlist(List<paylasimlar> paylasimlist) {
        mainpage.paylasimlist = paylasimlist;
    }

    public List<paylasimlar> gonderiler() throws SQLException {

        return paylasimlist;
    }

    public String takipet(User user) throws SQLException {
        mainpageDAO.ekle(user);
        return "search";
    }

    public List<User> getUserList() throws SQLException {
        userlist = new ArrayList<>();
        mainpage.userlist = mainpageDAO.search(mainpage.search);
        return userlist;
    }

    public void setUserList(List<User> userlist) {
        this.userlist = userlist;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    public String Share() throws SQLException {

        mainpageDAO.sharedb(Login.user1.user_id, this.sharing);
        return "admin";
    }

}
