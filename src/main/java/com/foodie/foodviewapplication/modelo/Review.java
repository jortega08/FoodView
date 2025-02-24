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
public class Review {
    private int idReview;
    private String description;
    private float stars;
    private Date date;
    private int fkIdUser;
    private int fkIdPlace;

    public Review(int idReview, String description, float stars, Date date, int fkIdUser, int fkIdPlace) {
        this.idReview = idReview;
        this.description = description;
        this.stars = stars;
        this.date = date;
        this.fkIdUser = fkIdUser;
        this.fkIdPlace = fkIdPlace;
    }

    public Review() {
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
