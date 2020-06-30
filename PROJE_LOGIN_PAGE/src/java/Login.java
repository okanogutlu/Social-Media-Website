import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
@ManagedBean
@SessionScoped
@RequestScoped
public class Login implements Serializable{
    User user;
    public static User user1;

    public  User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        user1 = user1;
    }
    
    public User getUser() {
        if(user == null)
            user = new User();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    //Validate Login
    public String validateUsernamePassword(){
        Login.user1 = LoginDAO.validate(user.getEmail(),user.getPassword());
        this.user=user1;
        if(user1.user_id!=0){
            return "admin";
        }
        else{
            return "login";
        }
    }
    public String kayit(){
       boolean validate = LoginDAO.kayitYap(user.getName(),user.getSurname(), user.getEmail(),user.getPassword(),user.getGender());
        if(validate)
            return "success";
        else
            return "unsuccess";
    }
    public String logout(){
        return "login";
    }
    public String anaSayfa(String email){
        this.user.setEmail(email);
        return "anasayfa";
    }
    public String setting(){
        user = user1;
        return "setting";
    }
}