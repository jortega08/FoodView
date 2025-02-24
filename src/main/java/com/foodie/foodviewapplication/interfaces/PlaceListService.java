/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.PlaceList;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PlaceListService {
    public boolean addPlaceList(PlaceList placeList);
    public PlaceList getPlaceListById(int idPlaceList);
    public boolean updatePlaceList(PlaceList placeList);
    public boolean deletePlaceList(int idPlaceList);
    public List<PlaceList> getAllPlaceLists();
    
}
