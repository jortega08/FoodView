/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.User;

/**
 *
 * @author juan ortega
 */
public interface UserService {
    public boolean addUser(User user);
    public void updateUser(User user);
    public void dalateUser(User user);
    
}
