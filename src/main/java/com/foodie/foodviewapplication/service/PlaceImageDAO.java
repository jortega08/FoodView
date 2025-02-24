/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlaceImageService;
import com.foodie.foodviewapplication.modelo.PlaceImage;
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
public class PlaceImageDAO implements PlaceImageService{
    private Connection connection;

    public PlaceImageDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addPlaceImage(PlaceImage placeImage) {
        String query = "INSERT INTO place_image (image, fk_id_place) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBytes(1, placeImage.getImage());
            statement.setInt(2, placeImage.getFkIdPlace());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PlaceImage getPlaceImageById(int idPlaceImage) {
        String query = "SELECT * FROM place_image WHERE id_place_image = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlaceImage);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PlaceImage placeImage = new PlaceImage();
                placeImage.setIdPlaceImage(resultSet.getInt("id_place_image"));
                placeImage.setImage(resultSet.getBytes("image"));
                placeImage.setFkIdPlace(resultSet.getInt("fk_id_place"));
                return placeImage;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePlaceImage(PlaceImage placeImage) {
        String query = "UPDATE place_image SET image = ?, fk_id_place = ? WHERE id_place_image = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBytes(1, placeImage.getImage());
            statement.setInt(2, placeImage.getFkIdPlace());
            statement.setInt(3, placeImage.getIdPlaceImage());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlaceImage(int idPlaceImage) {
        String query = "DELETE FROM place_image WHERE id_place_image = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlaceImage);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PlaceImage> getAllPlaceImages() {
        String query = "SELECT * FROM place_image";
        List<PlaceImage> placeImageList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlaceImage placeImage = new PlaceImage();
                placeImage.setIdPlaceImage(resultSet.getInt("id_place_image"));
                placeImage.setImage(resultSet.getBytes("image"));
                placeImage.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placeImageList.add(placeImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeImageList;
    }
    
}
