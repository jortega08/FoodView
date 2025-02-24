/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlaceListService;
import com.foodie.foodviewapplication.modelo.PlaceList;
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
public class PlaceListDAO implements PlaceListService{

    private Connection connection;

    public PlaceListDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    @Override
    public boolean addPlaceList(PlaceList placeList) {
        String query = "INSERT INTO place_list (name, description, image, fk_id_user) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, placeList.getName());
            statement.setString(2, placeList.getDescription());
            statement.setBytes(3, placeList.getImage());
            statement.setInt(4, placeList.getFkIdUser());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public PlaceList getPlaceListById(int idPlaceList) {
        String query = "SELECT * FROM place_list WHERE id_place_list = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlaceList);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PlaceList placeList = new PlaceList();
                placeList.setIdPlaceList(resultSet.getInt("id_place_list"));
                placeList.setName(resultSet.getString("name"));
                placeList.setDescription(resultSet.getString("description"));
                placeList.setImage(resultSet.getBytes("image"));
                placeList.setFkIdUser(resultSet.getInt("fk_id_user"));
                return placeList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePlaceList(PlaceList placeList) {
        String query = "UPDATE place_list SET name = ?, description = ?, image = ?, fk_id_user = ? WHERE id_place_list = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, placeList.getName());
            statement.setString(2, placeList.getDescription());
            statement.setBytes(3, placeList.getImage());
            statement.setInt(4, placeList.getFkIdUser());
            statement.setInt(5, placeList.getIdPlaceList());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlaceList(int idPlaceList) {
        String query = "DELETE FROM place_list WHERE id_place_list = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlaceList);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PlaceList> getAllPlaceLists() {
        String query = "SELECT * FROM place_list";
        List<PlaceList> placeListList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlaceList placeList = new PlaceList();
                placeList.setIdPlaceList(resultSet.getInt("id_place_list"));
                placeList.setName(resultSet.getString("name"));
                placeList.setDescription(resultSet.getString("description"));
                placeList.setImage(resultSet.getBytes("image"));
                placeList.setFkIdUser(resultSet.getInt("fk_id_user"));
                placeListList.add(placeList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeListList;
    }
    
    
    
}
