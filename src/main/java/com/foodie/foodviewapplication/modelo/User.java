/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

import java.util.Date;

/**
 *
 * @author juan ortega
 */
public class User {
    private int idUser;
    private String givenName;
    private String familyName;
    private String email;
    private String gender;
    private Date birthday;
    private String status;
    private int fkIdTown;
    private String password;

    public User(int idUser, String givenName, String familyName, String email, String gender, Date birthday, String status, int fkIdTown, String password) {
        this.idUser = idUser;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.fkIdTown = fkIdTown;
        this.password = password;
    }

    public User(String givenName, String familyName, String email, String gender, Date birthday, String status, int fkIdTown, String password) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.fkIdTown = fkIdTown;
        this.password = password;
    }

    
    
    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFkIdTown() {
        return fkIdTown;
    }

    public void setFkIdTown(int fkIdTown) {
        this.fkIdTown = fkIdTown;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
