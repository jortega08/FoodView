/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.UserPreferences;
import java.util.List;
/**
 *
 * @author juan ortega
 */
public interface UserPreferencesService {
    public boolean addUserPreferences(UserPreferences userPreferences);
    public UserPreferences getUserPreferencesById(int idUserPreferences);
    public boolean deleteUserPreferences(int idUserPreferences);
    public List<UserPreferences> getAllUserPreferences();
    
}
