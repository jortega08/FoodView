/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class PlaceImage {
    private int idPlaceImage;
    private byte[] image;
    private int fkIdPlace;

    public PlaceImage(int idPlaceImage, byte[] image, int fkIdPlace) {
        this.idPlaceImage = idPlaceImage;
        this.image = image;
        this.fkIdPlace = fkIdPlace;
    }

    public PlaceImage() {
    }

    public int getIdPlaceImage() {
        return idPlaceImage;
    }

    public void setIdPlaceImage(int idPlaceImage) {
        this.idPlaceImage = idPlaceImage;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getFkIdPlace() {
        return fkIdPlace;
    }

    public void setFkIdPlace(int fkIdPlace) {
        this.fkIdPlace = fkIdPlace;
    }
    
    
}
