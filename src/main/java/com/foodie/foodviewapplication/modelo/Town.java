/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class Town {
    private int idTown;
    private String name;
    private int fkIdDepartment;

    public Town(int idTown, String name, int fkIdDepartment) {
        this.idTown = idTown;
        this.name = name;
        this.fkIdDepartment = fkIdDepartment;
    }

    public Town() {
    }

    public int getIdTown() {
        return idTown;
    }

    public void setIdTown(int idTown) {
        this.idTown = idTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFkIdDepartment() {
        return fkIdDepartment;
    }

    public void setFkIdDepartment(int fkIdDepartment) {
        this.fkIdDepartment = fkIdDepartment;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
