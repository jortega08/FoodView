/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.PlacePreferences;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PlacePreferencesService {
    public boolean addPlacePreferences(PlacePreferences placePreferences);
    public PlacePreferences getPlacePreferencesById(int idPlacePreferences);
    public boolean deletePlacePreferences(int idPlacePreferences);
    public List<PlacePreferences> getAllPlacePreferences();
}
