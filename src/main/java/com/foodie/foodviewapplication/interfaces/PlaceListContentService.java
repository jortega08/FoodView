/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.PlaceListContent;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PlaceListContentService {
    public boolean addPlaceListContent(PlaceListContent placeListContent);
    public PlaceListContent getPlaceListContentById(int idContent);
    public boolean updatePlaceListContent(PlaceListContent placeListContent);
    public boolean deletePlaceListContent(int idContent);
    public List<PlaceListContent> getAllPlaceListContents();
}
