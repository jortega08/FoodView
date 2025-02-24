/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.modelo;

/**
 *
 * @author juan ortega
 */
public class Friendship {
    private int idFriendship;
    private int fkIdUserSend;
    private int fkIdUserReceive;
    private String status;

    public Friendship(int idFriendship, int fkIdUserSend, int fkIdUserReceive, String status) {
        this.idFriendship = idFriendship;
        this.fkIdUserSend = fkIdUserSend;
        this.fkIdUserReceive = fkIdUserReceive;
        this.status = status;
    }

    public Friendship() {
    }

    public int getIdFriendship() {
        return idFriendship;
    }

    public void setIdFriendship(int idFriendship) {
        this.idFriendship = idFriendship;
    }

    public int getFkIdUserSend() {
        return fkIdUserSend;
    }

    public void setFkIdUserSend(int fkIdUserSend) {
        this.fkIdUserSend = fkIdUserSend;
    }

    public int getFkIdUserReceive() {
        return fkIdUserReceive;
    }

    public void setFkIdUserReceive(int fkIdUserReceive) {
        this.fkIdUserReceive = fkIdUserReceive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
