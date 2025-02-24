/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class PlacePreferences {
    private int idPlacePreferences;
    private int fkIdPlace;
    private int fkIdPreferences;

    public PlacePreferences() {
    }

    public PlacePreferences(int idPlacePreferences, int fkIdPlace, int fkIdPreferences) {
        this.idPlacePreferences = idPlacePreferences;
        this.fkIdPlace = fkIdPlace;
        this.fkIdPreferences = fkIdPreferences;
    }

    public int getIdPlacePreferences() {
        return idPlacePreferences;
    }

    public void setIdPlacePreferences(int idPlacePreferences) {
        this.idPlacePreferences = idPlacePreferences;
    }

    public int getFkIdPlace() {
        return fkIdPlace;
    }

    public void setFkIdPlace(int fkIdPlace) {
        this.fkIdPlace = fkIdPlace;
    }

    public int getFkIdPreferences() {
        return fkIdPreferences;
    }

    public void setFkIdPreferences(int fkIdPreferences) {
        this.fkIdPreferences = fkIdPreferences;
    }
    
    
    
}
