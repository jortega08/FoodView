/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.UserService;
import java.sql.Connection;
import com.foodie.foodviewapplication.modelo.User;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan ortega
 */
public class UserDAO implements UserService {

    private Connection connection;

    public UserDAO() {
        connection = (Connection) DatabaseConnection.getConnection();
    }

    @Override
    public boolean addUser(User user) {
        String query = "INSERT INTO usertable (given_name, familary_name, email, gender, birthday, status, FK_id_town_u, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        boolean isRegistered = false;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getGivenName());
            statement.setString(2, user.getFamilyName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getGender());
            statement.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            statement.setString(6, user.getStatus());
            statement.setInt(7, user.getFkIdTown());
            statement.setString(8, user.getPassword());

            int rowsInserted = statement.executeUpdate();
            isRegistered = (rowsInserted > 0);
            if (isRegistered) {
                System.out.println("Usuario añadido exitosamente.");
            } else {
                System.out.println("Error al añadir el usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al añadir el usuario: " + e.getMessage());
        }

        return isRegistered;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE usertable SET given_name = ?, familary_name = ?, email = ?, gender = ?, birthday = ?, status = ?, FK_id_town_u = ?, password = ? WHERE id_user = ?";

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getGivenName());
            statement.setString(2, user.getFamilyName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getGender());
            statement.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            statement.setString(6, user.getStatus());
            statement.setInt(7, user.getFkIdTown());
            statement.setString(8, user.getPassword());
            statement.setInt(9, user.getIdUser());

            statement.executeUpdate();
            System.out.println("Usuario actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @Override
    public void dalateUser(User user) {
        String query = "DELETE FROM usertable WHERE id_user = ?";

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getIdUser());
            statement.executeUpdate();
            System.out.println("Usuario eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM foodview.usertable WHERE email = ?";
        User user = null;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password)) {
                        user = new User();
                        user.setIdUser(resultSet.getInt("id_user"));
                        user.setGivenName(resultSet.getString("given_name"));
                        user.setFamilyName(resultSet.getString("familary_name"));
                        user.setEmail(resultSet.getString("email"));
                        user.setGender(resultSet.getString("gender"));
                        user.setBirthday(resultSet.getDate("birthday"));
                        user.setStatus(resultSet.getString("status"));
                        user.setFkIdTown(resultSet.getInt("FK_id_town_u"));
                        user.setPassword(resultSet.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al buscar usuario por email y contraseña: " + e.getMessage());
        }

        return user;
    }
    
     public User getUserById(int userId) {
        String query = "SELECT * FROM foodview.usertable WHERE id_user = ?";
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setIdUser(resultSet.getInt("id_user"));
                    user.setGivenName(resultSet.getString("given_name"));
                    user.setFamilyName(resultSet.getString("familary_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setGender(resultSet.getString("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setStatus(resultSet.getString("status"));
                    user.setFkIdTown(resultSet.getInt("FK_id_town_u"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener usuario por ID: " + e.getMessage());
        }

        return user;
    }

    
}
