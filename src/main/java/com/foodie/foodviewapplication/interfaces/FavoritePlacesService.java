/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.FavoritePlaces;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface FavoritePlacesService {
    public boolean addFavoritePlace(FavoritePlaces favoritePlace);
    public FavoritePlaces getFavoritePlaceById(int idFavoritePlaces);
    public boolean updateFavoritePlace(FavoritePlaces favoritePlace);
    public boolean deleteFavoritePlace(int idFavoritePlaces);
    public List<FavoritePlaces> getFavoritePlacesByUserId(int fkIdUser);
}
