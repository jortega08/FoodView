/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.Preferences;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PreferencesService {
    public boolean addPreferences(Preferences preferences);
    public Preferences getPreferencesById(int idPreferences);
    public boolean deletePreferences(int idPreferences);
    public List<Preferences> getAllPreferences();
}
