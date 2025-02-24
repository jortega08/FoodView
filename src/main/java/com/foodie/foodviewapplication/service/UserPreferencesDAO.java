/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;
import com.foodie.foodviewapplication.interfaces.UserPreferencesService;
import com.foodie.foodviewapplication.modelo.UserPreferences;
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
public class UserPreferencesDAO implements UserPreferencesService{

    private Connection connection;

    public UserPreferencesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addUserPreferences(UserPreferences userPreferences) {
        String query = "INSERT INTO user_preferences (fk_id_user, fk_id_preferences) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userPreferences.getFkIdUser());
            statement.setInt(2, userPreferences.getFkIdPreferences());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserPreferences getUserPreferencesById(int idUserPreferences) {
         String query = "SELECT * FROM user_preferences WHERE id_user_preferences = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUserPreferences);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserPreferences userPreferences = new UserPreferences();
                userPreferences.setIdUserPreferences(resultSet.getInt("id_user_preferences"));
                userPreferences.setFkIdUser(resultSet.getInt("fk_id_user"));
                userPreferences.setFkIdPreferences(resultSet.getInt("fk_id_preferences"));
                return userPreferences;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserPreferences> getAllUserPreferences() {
        String query = "SELECT * FROM user_preferences";
        List<UserPreferences> userPreferencesList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserPreferences userPreferences = new UserPreferences();
                userPreferences.setIdUserPreferences(resultSet.getInt("id_user_preferences"));
                userPreferences.setFkIdUser(resultSet.getInt("fk_id_user"));
                userPreferences.setFkIdPreferences(resultSet.getInt("fk_id_preferences"));
                userPreferencesList.add(userPreferences);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPreferencesList;
    }

    @Override
    public boolean deleteUserPreferences(int idUserPreferences) {
        String query = "DELETE FROM user_preferences WHERE id_user_preferences = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUserPreferences);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
