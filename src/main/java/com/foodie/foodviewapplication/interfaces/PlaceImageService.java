/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.PlaceImage;
import java.util.List;


/**
 *
 * @author juan ortega
 */
public interface PlaceImageService {
    public boolean addPlaceImage(PlaceImage placeImage);
    public PlaceImage getPlaceImageById(int idPlaceImage);
    public boolean updatePlaceImage(PlaceImage placeImage);
    public boolean deletePlaceImage(int idPlaceImage);
    public List<PlaceImage> getAllPlaceImages();
}
