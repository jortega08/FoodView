/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlacePreferencesService;
import com.foodie.foodviewapplication.modelo.PlacePreferences;
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
public class PlacePreferencesDAO implements PlacePreferencesService {

    private Connection connection;

    public PlacePreferencesDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addPlacePreferences(PlacePreferences placePreferences) {
        String query = "INSERT INTO place_preferences (fk_id_place, fk_id_preferences) VALUES (?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placePreferences.getFkIdPlace());
            statement.setInt(2, placePreferences.getFkIdPreferences());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PlacePreferences getPlacePreferencesById(int idPlacePreferences) {
        String query = "SELECT * FROM place_preferences WHERE id_place_preferences = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlacePreferences);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PlacePreferences placePreferences = new PlacePreferences();
                placePreferences.setIdPlacePreferences(resultSet.getInt("id_place_preferences"));
                placePreferences.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placePreferences.setFkIdPreferences(resultSet.getInt("fk_id_preferences_pp"));
                return placePreferences;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletePlacePreferences(int idPlacePreferences) {
        String query = "DELETE FROM place_preferences WHERE id_place_preferences = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlacePreferences);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PlacePreferences> getAllPlacePreferences() {
        String query = "SELECT * FROM place_preferences";
        List<PlacePreferences> placePreferencesList = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlacePreferences placePreferences = new PlacePreferences();
                placePreferences.setIdPlacePreferences(resultSet.getInt("id_place_preferences"));
                placePreferences.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placePreferences.setFkIdPreferences(resultSet.getInt("fk_id_preferences_pp"));
                placePreferencesList.add(placePreferences);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placePreferencesList;
    }

    public List<PlacePreferences> getPlacePreferencesByPlaceId(int placeId) {
        String query = "SELECT * FROM place_preferences WHERE fk_id_place_pp = ?";
        List<PlacePreferences> placePreferencesList = new ArrayList<>();

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PlacePreferences placePreferences = new PlacePreferences();
                    placePreferences.setIdPlacePreferences(resultSet.getInt("id_place_preferences"));
                    placePreferences.setFkIdPlace(resultSet.getInt("fk_id_place_pp"));
                    placePreferences.setFkIdPreferences(resultSet.getInt("fk_id_preferences_pp"));
                    placePreferencesList.add(placePreferences);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las preferencias del lugar: " + e.getMessage());
        }

        return placePreferencesList;
    }
}
