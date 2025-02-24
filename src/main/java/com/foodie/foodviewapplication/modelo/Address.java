/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class Address {
    private int idAddress;
    private String street;
    private String streetNumber;
    private String streetComplement;
    private String neighborhood;
    private int fkIdTown;

    public Address(int idAddress, String street, String streetNumber, String streetComplement, String neighborhood, int fkIdTown) {
        this.idAddress = idAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.streetComplement = streetComplement;
        this.neighborhood = neighborhood;
        this.fkIdTown = fkIdTown;
    }

    public Address(String street, String streetNumber, String streetComplement, String neighborhood, int fkIdTown) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.streetComplement = streetComplement;
        this.neighborhood = neighborhood;
        this.fkIdTown = fkIdTown;
    }

    public Address() {
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetComplement() {
        return streetComplement;
    }

    public void setStreetComplement(String streetComplement) {
        this.streetComplement = streetComplement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getFkIdTown() {
        return fkIdTown;
    }

    public void setFkIdTown(int fkIdTown) {
        this.fkIdTown = fkIdTown;
    }
    
    
}
