/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.Place;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PlaceService {
    public boolean createPlace(Place place);
    public Place getPlaceById(int idPlace);
    public List<Place> getAllPlaces() throws Exception;
    public boolean updatePlace(Place place);
    public boolean deletePlace(int idPlace);
}
