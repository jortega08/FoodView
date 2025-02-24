/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class FavoritePlaces {
    private int idFavoritePlaces;
    private int fkIdUser;
    private int fkIdPlace;

    public FavoritePlaces(int idFavoritePlaces, int fkIdUser, int fkIdPlace) {
        this.idFavoritePlaces = idFavoritePlaces;
        this.fkIdUser = fkIdUser;
        this.fkIdPlace = fkIdPlace;
    }

    public FavoritePlaces() {
    }

    public int getIdFavoritePlaces() {
        return idFavoritePlaces;
    }

    public void setIdFavoritePlaces(int idFavoritePlaces) {
        this.idFavoritePlaces = idFavoritePlaces;
    }

    public int getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(int fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public int getFkIdPlace() {
        return fkIdPlace;
    }

    public void setFkIdPlace(int fkIdPlace) {
        this.fkIdPlace = fkIdPlace;
    }
    
    
}
