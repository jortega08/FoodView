/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.AddressService;
import com.foodie.foodviewapplication.modelo.Address;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author juan ortega
 */
public class AddressDAO implements AddressService{
    
    private Connection connection;

    public AddressDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createAddress(Address address) {
        String query = "INSERT INTO address (street, street_number, street_complement, neighborhood, fk_id_town_a) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getStreetNumber());
            statement.setString(3, address.getStreetComplement());
            statement.setString(4, address.getNeighborhood());
            statement.setInt(5, address.getFkIdTown());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Address getAddressById(int idAddress) {
        String query = "SELECT * FROM address WHERE id_address = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idAddress);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Address address = new Address();
                address.setIdAddress(resultSet.getInt("id_address"));
                address.setStreet(resultSet.getString("street"));
                address.setStreetNumber(resultSet.getString("street_number"));
                address.setStreetComplement(resultSet.getString("street_complement"));
                address.setNeighborhood(resultSet.getString("neighborhood"));
                address.setFkIdTown(resultSet.getInt("fk_id_town_a"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAddress(Address address) {
        String query = "UPDATE address SET street = ?, street_number = ?, street_complement = ?, neighborhood = ?, fk_id_town_a = ? WHERE id_address = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getStreetNumber());
            statement.setString(3, address.getStreetComplement());
            statement.setString(4, address.getNeighborhood());
            statement.setInt(5, address.getFkIdTown());
            statement.setInt(6, address.getIdAddress());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAddress(int idAddress) {
        String query = "DELETE FROM address WHERE id_address = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idAddress);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
