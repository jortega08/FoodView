/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class PlaceListContent {
    private int idContent;
    private int fkIdPlace;
    private int fkIdPlaceList;

    public PlaceListContent(int idContent, int fkIdPlace, int fkIdPlaceList) {
        this.idContent = idContent;
        this.fkIdPlace = fkIdPlace;
        this.fkIdPlaceList = fkIdPlaceList;
    }

    public PlaceListContent() {
    }

    public int getIdContent() {
        return idContent;
    }

    public void setIdContent(int idContent) {
        this.idContent = idContent;
    }

    public int getFkIdPlace() {
        return fkIdPlace;
    }

    public void setFkIdPlace(int fkIdPlace) {
        this.fkIdPlace = fkIdPlace;
    }

    public int getFkIdPlaceList() {
        return fkIdPlaceList;
    }

    public void setFkIdPlaceList(int fkIdPlaceList) {
        this.fkIdPlaceList = fkIdPlaceList;
    }
    
    
}
