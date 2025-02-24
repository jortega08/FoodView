/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.PlaceMetrics;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface PlaceMetricsService {
    public boolean addPlaceMetrics(PlaceMetrics placeMetrics);
    public PlaceMetrics getPlaceMetricsById(int idMetrics);
    public boolean updatePlaceMetrics(PlaceMetrics placeMetrics);
    public boolean deletePlaceMetrics(int idMetrics);
    public List<PlaceMetrics> getAllPlaceMetrics();
}
