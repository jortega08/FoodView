/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlaceListContentService;
import com.foodie.foodviewapplication.modelo.PlaceListContent;
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
public class PlaceListContentDAO implements PlaceListContentService{
    private Connection connection;

    public PlaceListContentDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addPlaceListContent(PlaceListContent placeListContent) {
        String query = "INSERT INTO place_list_content (fk_id_place, fk_id_place_list) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeListContent.getFkIdPlace());
            statement.setInt(2, placeListContent.getFkIdPlaceList());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PlaceListContent getPlaceListContentById(int idContent) {
        String query = "SELECT * FROM place_list_content WHERE id_content = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idContent);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PlaceListContent placeListContent = new PlaceListContent();
                placeListContent.setIdContent(resultSet.getInt("id_content"));
                placeListContent.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placeListContent.setFkIdPlaceList(resultSet.getInt("fk_id_place_list"));
                return placeListContent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePlaceListContent(PlaceListContent placeListContent) {
        String query = "UPDATE place_list_content SET fk_id_place = ?, fk_id_place_list = ? WHERE id_content = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeListContent.getFkIdPlace());
            statement.setInt(2, placeListContent.getFkIdPlaceList());
            statement.setInt(3, placeListContent.getIdContent());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlaceListContent(int idContent) {
        String query = "DELETE FROM place_list_content WHERE id_content = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idContent);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PlaceListContent> getAllPlaceListContents() {
        String query = "SELECT * FROM place_list_content";
        List<PlaceListContent> placeListContents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlaceListContent placeListContent = new PlaceListContent();
                placeListContent.setIdContent(resultSet.getInt("id_content"));
                placeListContent.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placeListContent.setFkIdPlaceList(resultSet.getInt("fk_id_place_list"));
                placeListContents.add(placeListContent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeListContents;
    }
    
    public int countPlaceListsByPlace(int placeId) {
        String query = "SELECT COUNT(*) FROM placelistcontent WHERE fk_id_place_c = ?";
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
