/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.modelo.Town;
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
public class TownDAO {

    private Connection connection;

    public TownDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Town> getCitiesByDepartment(int departmentId) {
        List<Town> cities = new ArrayList<>();
        String query = "SELECT id_town, name FROM foodview.town WHERE fk_id_deparment_t = ?";

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departmentId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Town city = new Town();
                    city.setIdTown(resultSet.getInt("id_town"));
                    city.setName(resultSet.getString("name"));
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las ciudades: " + e.getMessage());
        }

        return cities;
    }

    public Integer getTownIdByName(String townName) {
        String query = "SELECT id_town FROM foodview.town WHERE name = ?";
        Integer townId = null;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, townName);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    townId = resultSet.getInt("id_town");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el ID de la ciudad: " + e.getMessage());
        }

        return townId;
    }

    public Town getTownById(int townId) {
        String query = "SELECT id_town, name, fk_id_deparment_t  FROM foodview.town WHERE id_town = ?";
        Town town = null;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, townId);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    town = new Town();
                    town.setIdTown(resultSet.getInt("id_town"));
                    town.setName(resultSet.getString("name"));
                    town.setFkIdDepartment(resultSet.getInt("fk_id_deparment_t"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la ciudad por ID: " + e.getMessage());
        }

        return town;
    }
}
