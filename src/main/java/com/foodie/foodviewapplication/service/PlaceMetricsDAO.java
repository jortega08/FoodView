/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.PlaceMetricsService;
import com.foodie.foodviewapplication.modelo.PlaceMetrics;
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
public class PlaceMetricsDAO implements PlaceMetricsService{

    private Connection connection;

    public PlaceMetricsDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    @Override
    public boolean addPlaceMetrics(PlaceMetrics placeMetrics) {
        String query = "INSERT INTO place_metrics (cont_review, cont_likes, cont_place_list, fk_id_place) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeMetrics.getContReview());
            statement.setInt(2, placeMetrics.getContLikes());
            statement.setInt(3, placeMetrics.getContPlaceList());
            statement.setInt(4, placeMetrics.getFkIdPlace());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PlaceMetrics getPlaceMetricsById(int idMetrics) {
        String query = "SELECT * FROM place_metrics WHERE id_metrics = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMetrics);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PlaceMetrics placeMetrics = new PlaceMetrics();
                placeMetrics.setIdMetrics(resultSet.getInt("id_metrics"));
                placeMetrics.setContReview(resultSet.getInt("cont_review"));
                placeMetrics.setContLikes(resultSet.getInt("cont_likes"));
                placeMetrics.setContPlaceList(resultSet.getInt("cont_place_list"));
                placeMetrics.setFkIdPlace(resultSet.getInt("fk_id_place"));
                return placeMetrics;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePlaceMetrics(PlaceMetrics placeMetrics) {
        String query = "UPDATE place_metrics SET cont_review = ?, cont_likes = ?, cont_place_list = ?, fk_id_place = ? WHERE id_metrics = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeMetrics.getContReview());
            statement.setInt(2, placeMetrics.getContLikes());
            statement.setInt(3, placeMetrics.getContPlaceList());
            statement.setInt(4, placeMetrics.getFkIdPlace());
            statement.setInt(5, placeMetrics.getIdMetrics());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlaceMetrics(int idMetrics) {
        String query = "DELETE FROM place_metrics WHERE id_metrics = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMetrics);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PlaceMetrics> getAllPlaceMetrics() {
        String query = "SELECT * FROM place_metrics";
        List<PlaceMetrics> placeMetricsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlaceMetrics placeMetrics = new PlaceMetrics();
                placeMetrics.setIdMetrics(resultSet.getInt("id_metrics"));
                placeMetrics.setContReview(resultSet.getInt("cont_review"));
                placeMetrics.setContLikes(resultSet.getInt("cont_likes"));
                placeMetrics.setContPlaceList(resultSet.getInt("cont_place_list"));
                placeMetrics.setFkIdPlace(resultSet.getInt("fk_id_place"));
                placeMetricsList.add(placeMetrics);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeMetricsList;
    }
    
}
