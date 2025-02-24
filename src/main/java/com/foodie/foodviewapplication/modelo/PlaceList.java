/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class PlaceList {
    private int idPlaceList;
    private String name;
    private String description;
    private byte[] image;
    private int fkIdUser;

    public PlaceList(int idPlaceList, String name, String description, byte[] image, int fkIdUser) {
        this.idPlaceList = idPlaceList;
        this.name = name;
        this.description = description;
        this.image = image;
        this.fkIdUser = fkIdUser;
    }

    public PlaceList() {
    }

    public int getIdPlaceList() {
        return idPlaceList;
    }

    public void setIdPlaceList(int idPlaceList) {
        this.idPlaceList = idPlaceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(int fkIdUser) {
        this.fkIdUser = fkIdUser;
    }
    
    
    
    
}
