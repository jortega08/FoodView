/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PreferencesService;
import com.foodie.foodviewapplication.modelo.Preferences;
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
public class PreferencesDAO implements PreferencesService{
    
    private Connection connection;

    public PreferencesDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addPreferences(Preferences preferences) {
        String query = "INSERT INTO preferences (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, preferences.getName());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Preferences getPreferencesById(int idPreferences) {
        String query = "SELECT * FROM preferences WHERE id_preferences = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPreferences);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Preferences preferences = new Preferences();
                preferences.setIdPreferences(resultSet.getInt("id_preferences"));
                preferences.setName(resultSet.getString("name"));
                return preferences;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletePreferences(int idPreferences) {
        String query = "DELETE FROM preferences WHERE id_preferences = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPreferences);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Preferences> getAllPreferences() {
        String query = "SELECT * FROM preferences";
        List<Preferences> preferencesList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Preferences preferences = new Preferences();
                preferences.setIdPreferences(resultSet.getInt("id_preferences"));
                preferences.setName(resultSet.getString("name"));
                preferencesList.add(preferences);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preferencesList;
    }
}
