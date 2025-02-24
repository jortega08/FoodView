/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.FavoritePlacesService;
import com.foodie.foodviewapplication.modelo.FavoritePlaces;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public class FavoritePlacesDAO implements FavoritePlacesService{
    
    private Connection connection;

    public FavoritePlacesDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    @Override
    public boolean addFavoritePlace(FavoritePlaces favoritePlace) {
        String query = "INSERT INTO favoriteplaces (fk_id_user_fp, fk_id_place_fp) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, favoritePlace.getFkIdUser());
            statement.setInt(2, favoritePlace.getFkIdPlace());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FavoritePlaces getFavoritePlaceById(int idFavoritePlaces) {
        String query = "SELECT * FROM favoriteplaces WHERE id_favoriteplaces = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFavoritePlaces);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                FavoritePlaces favoritePlace = new FavoritePlaces();
                favoritePlace.setIdFavoritePlaces(resultSet.getInt("id_favoriteplaces"));
                favoritePlace.setFkIdUser(resultSet.getInt("fk_id_user_fp"));
                favoritePlace.setFkIdPlace(resultSet.getInt("fk_id_place_fp"));
                return favoritePlace;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateFavoritePlace(FavoritePlaces favoritePlace) {
        String query = "UPDATE favoriteplaces SET fk_id_user_fp = ?, fk_id_place_fp = ? WHERE id_favoriteplaces = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, favoritePlace.getFkIdUser());
            statement.setInt(2, favoritePlace.getFkIdPlace());
            statement.setInt(3, favoritePlace.getIdFavoritePlaces());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFavoritePlace(int idFavoritePlaces) {
        String query = "DELETE FROM favoriteplaces WHERE id_favoriteplaces = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFavoritePlaces);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FavoritePlaces> getFavoritePlacesByUserId(int fkIdUser) {
        String query = "SELECT * FROM favoriteplaces WHERE fk_id_user_fp = ?";
        List<FavoritePlaces> favoritePlacesList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, fkIdUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FavoritePlaces favoritePlace = new FavoritePlaces();
                favoritePlace.setIdFavoritePlaces(resultSet.getInt("id_favoriteplaces"));
                favoritePlace.setFkIdUser(resultSet.getInt("fk_id_user_fp"));
                favoritePlace.setFkIdPlace(resultSet.getInt("fk_id_place_fp"));
                favoritePlacesList.add(favoritePlace);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoritePlacesList;
    }
    
    public int countLikesByPlace(int placeId) {
        String query = "SELECT COUNT(*) FROM favoriteplaces WHERE fk_id_place_fp = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al contar los PlaceLists: " + e.getMessage());
        }
        return 0;
    }
    
}
