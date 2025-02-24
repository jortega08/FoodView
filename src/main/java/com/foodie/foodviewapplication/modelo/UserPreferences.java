/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class UserPreferences {
    private int idUserPreferences;
    private int fkIdUser;
    private int fkIdPreferences;

    public UserPreferences(int idUserPreferences, int fkIdUser, int fkIdPreferences) {
        this.idUserPreferences = idUserPreferences;
        this.fkIdUser = fkIdUser;
        this.fkIdPreferences = fkIdPreferences;
    }

    public UserPreferences() {
    }

    public int getIdUserPreferences() {
        return idUserPreferences;
    }

    public void setIdUserPreferences(int idUserPreferences) {
        this.idUserPreferences = idUserPreferences;
    }

    public int getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(int fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public int getFkIdPreferences() {
        return fkIdPreferences;
    }

    public void setFkIdPreferences(int fkIdPreferences) {
        this.fkIdPreferences = fkIdPreferences;
    }
    
    
}
