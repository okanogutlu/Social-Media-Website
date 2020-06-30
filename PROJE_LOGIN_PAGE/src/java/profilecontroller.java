
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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
@ManagedBean
@SessionScoped
@RequestScoped
public class profilecontroller implements Serializable {
    
    public static User  user1;
    public static  List<paylasimlar> paylasimlist;

    public profilecontroller() {
        //paylasimlist=new ArrayList<>();
       //paylasimlar deneme=new paylasimlar(1,"merhaba arkadaşlar",1);
       //paylasimlist.add(deneme);
    }

    public  User getUser1() {
        return user1;
    }

    public  void setUser1(User user1) {
        profilecontroller.user1 = user1;
    }

    public  List<paylasimlar> getPaylasimlist() {
        return paylasimlist;
    }

    public  void setPaylasimlist(List<paylasimlar> paylasimlist) {
        profilecontroller.paylasimlist = paylasimlist;
    }

   

   
    public static String goruntule(User user){
        user1=user;
        paylasimlist=profileDAO.paylasimcek(user);
        return "profile?faces-redirect=true";
    }
}
