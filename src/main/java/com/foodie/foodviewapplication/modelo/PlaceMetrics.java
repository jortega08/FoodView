/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class PlaceMetrics {
    private int idMetrics;
    private int contReview;
    private int contLikes;
    private int contPlaceList;
    private int fkIdPlace;

    public PlaceMetrics(int idMetrics, int contReview, int contLikes, int contPlaceList, int fkIdPlace) {
        this.idMetrics = idMetrics;
        this.contReview = contReview;
        this.contLikes = contLikes;
        this.contPlaceList = contPlaceList;
        this.fkIdPlace = fkIdPlace;
    }

    public PlaceMetrics() {
    }

    public int getIdMetrics() {
        return idMetrics;
    }

    public void setIdMetrics(int idMetrics) {
        this.idMetrics = idMetrics;
    }

    public int getContReview() {
        return contReview;
    }

    public void setContReview(int contReview) {
        this.contReview = contReview;
    }

    public int getContLikes() {
        return contLikes;
    }

    public void setContLikes(int contLikes) {
        this.contLikes = contLikes;
    }

    public int getContPlaceList() {
        return contPlaceList;
    }

    public void setContPlaceList(int contPlaceList) {
        this.contPlaceList = contPlaceList;
    }

    public int getFkIdPlace() {
        return fkIdPlace;
    }

    public void setFkIdPlace(int fkIdPlace) {
        this.fkIdPlace = fkIdPlace;
    }
    
    
}
