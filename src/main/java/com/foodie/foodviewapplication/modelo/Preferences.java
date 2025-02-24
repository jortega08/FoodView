/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class Preferences {
    private int idPreferences;
    private String name;

    public Preferences(int idPreferences, String name) {
        this.idPreferences = idPreferences;
        this.name = name;
    }

    public Preferences() {
    }

    public int getIdPreferences() {
        return idPreferences;
    }

    public void setIdPreferences(int idPreferences) {
        this.idPreferences = idPreferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
