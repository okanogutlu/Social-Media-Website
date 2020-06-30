/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;

/**
 *
 * @author okano
 */
public class paylasimlar {
    public String name;
    public String surname;

    public paylasimlar(String name, String surname,int user_id, String paylasim,  Date date, int paylasim_id) {
        this.name = name;
        this.surname = surname;
        this.paylasim = paylasim;
        this.user_id = user_id;
        this.date = date;
        this.paylasim_id = paylasim_id;
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
    public String paylasim;
    public int user_id;
    public Date date;
    public int paylasim_id;

    public String getPaylasim() {
        return paylasim;
    }

    public void setPaylasim(String paylasim) {
        this.paylasim = paylasim;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public paylasimlar( int user_id,String paylasim, int paylasim_id) {
        this.paylasim = paylasim;
        this.user_id = user_id;
        this.paylasim_id = paylasim_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPaylasim_id() {
        return paylasim_id;
    }

    public void setPaylasim_id(int paylasim_id) {
        this.paylasim_id = paylasim_id;
    }

    public paylasimlar() {
    }

    public paylasimlar(int user_id,String paylasim,Date date, int paylasim_id) {
        this.paylasim = paylasim;
        this.user_id = user_id;
        this.date = date;
        this.paylasim_id = paylasim_id;
    }

   
}
