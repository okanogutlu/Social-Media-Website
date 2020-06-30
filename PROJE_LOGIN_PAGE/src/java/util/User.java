/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package util;
//

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author okano
 */
@ManagedBean
@SessionScoped
@RequestScoped
public class User implements Serializable {
    public int user_id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String gender;

    public User(int USER_ID, String NAME, String SURNAME, String EMAIL, String PASSWORD, String GENDER) {
        this.user_id = USER_ID;
        this.name = NAME;
        this.surname = SURNAME;
        this.email = EMAIL;
        this.password = PASSWORD;
        this.gender = GENDER;
    }

    

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

  
}
