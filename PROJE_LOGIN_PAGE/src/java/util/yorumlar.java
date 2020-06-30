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
public class yorumlar {
    public int paylasim_id;
    public String name;
    public String surname;
    public String comment;
    public Date date;

    public yorumlar(int paylasim_id, String name, String surname, String comment, Date date) {
        this.paylasim_id = paylasim_id;
        this.name = name;
        this.surname = surname;
        this.comment = comment;
        this.date = date;
    }

    public yorumlar() {
    }

    public int getPaylasim_id() {
        return paylasim_id;
    }

    public void setPaylasim_id(int paylasim_id) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
