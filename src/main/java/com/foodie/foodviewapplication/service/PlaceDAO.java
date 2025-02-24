/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlaceService;
import com.foodie.foodviewapplication.modelo.Place;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;
import java.sql.Connection;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan ortega
 */
public class PlaceDAO implements PlaceService {

    private Connection connection;

    public PlaceDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createPlace(Place place) {
        String query = "INSERT INTO place (name_place, description, email, phonenumber, fk_id_address, status) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, place.getNamePlace());
            statement.setString(2, place.getDescription());
            statement.setString(3, place.getEmail());
            statement.setString(4, place.getPhoneNumber());
            statement.setInt(5, place.getFkIdAddress());
            statement.setString(6, place.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Place getPlaceById(int idPlace) {
        String query = "SELECT * FROM place WHERE id_place = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlace);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Place place = new Place();
                place.setIdPlace(resultSet.getInt("id_place"));
                place.setNamePlace(resultSet.getString("name_place"));
                place.setDescription(resultSet.getString("description"));
                place.setEmail(resultSet.getString("email"));
                place.setPhoneNumber(resultSet.getString("phonenumber"));
                place.setFkIdAddress(resultSet.getInt("fk_id_address"));
                place.setStatus(resultSet.getString("status"));
                return place;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Place> getAllPlaces() {
        List<Place> places = new ArrayList<>();
        String query = "SELECT * FROM foodview.place";
        try ( PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Place place = new Place();
                place.setIdPlace(resultSet.getInt("id_place"));
                place.setNamePlace(resultSet.getString("name_place"));
                place.setDescription(resultSet.getString("description"));
                place.setEmail(resultSet.getString("email"));
                place.setPhoneNumber(resultSet.getString("phonenumber"));
                place.setFkIdAddress(resultSet.getInt("fk_id_address_p"));
                place.setStatus(resultSet.getString("status"));
                places.add(place);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return places;
    }

    @Override
    public boolean updatePlace(Place place) {
        String query = "UPDATE place SET name_place = ?, description = ?, email = ?, phonenumber = ?, fk_id_address = ?, status = ? WHERE id_place = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, place.getNamePlace());
            statement.setString(2, place.getDescription());
            statement.setString(3, place.getEmail());
            statement.setString(4, place.getPhoneNumber());
            statement.setInt(5, place.getFkIdAddress());
            statement.setString(6, place.getStatus());
            statement.setInt(7, place.getIdPlace());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlace(int idPlace) {
        String query = "DELETE FROM place WHERE id_place = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPlace);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Place getPlaceByName(String name) {
        String query = "SELECT * FROM place WHERE name_place = ?";
        Place place = new Place();
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                
                place.setIdPlace(resultSet.getInt("id_place"));
                place.setNamePlace(resultSet.getString("name_place"));
                place.setDescription(resultSet.getString("description"));
                place.setEmail(resultSet.getString("email"));
                place.setPhoneNumber(resultSet.getString("phonenumber"));
                place.setFkIdAddress(resultSet.getInt("fk_id_address_p"));
                place.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return place;
    }

}
