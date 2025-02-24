/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class Place {
    private int idPlace;
    private String namePlace;
    private String description;
    private String email;
    private String phoneNumber;
    private int fkIdAddress;
    private String status;

    public Place(int idPlace, String namePlace, String description, String email, String phoneNumber, int fkIdAddress, String status) {
        this.idPlace = idPlace;
        this.namePlace = namePlace;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fkIdAddress = fkIdAddress;
        this.status = status;
    }

    public Place(String namePlace, String description, String email, String phoneNumber, int fkIdAddress, String status) {
        this.namePlace = namePlace;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fkIdAddress = fkIdAddress;
        this.status = status;
    }
    
    public Place() {
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFkIdAddress() {
        return fkIdAddress;
    }

    public void setFkIdAddress(int fkIdAddress) {
        this.fkIdAddress = fkIdAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
