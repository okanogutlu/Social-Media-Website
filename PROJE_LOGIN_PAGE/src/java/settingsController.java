
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
public class settingsController implements Serializable {

    public static void isimguncelle() {

        settingsDAO.isimguncelleme(Login.user1);

        //return "settings";
    }

    public static String soyisimguncelle() {

        settingsDAO.soyisimguncelleme(Login.user1);

        return "settings";
    }

    public static String emailguncelle() {

        settingsDAO.emailguncelleme(Login.user1);

        return "settings";
    }

    public static String sifreguncelle() {

        settingsDAO.sifreguncelleme(Login.user1);

        return "settings";
    }

    public static String sil() {
        settingsDAO.silme(Login.user1);
        return "login";
    }
}
